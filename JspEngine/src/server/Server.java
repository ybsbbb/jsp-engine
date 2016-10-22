package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import javax.servlet.RequestImpl;
import javax.servlet.ResponseImpl;

import jsphandle.CompileJsp;
import jsphandle.ParseJsp;

public class Server {
    private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";

    public static void main(String[] args) {
    	//此处参数为jsp文件名称
    	ParseJsp.parseJsp("test.jsp");
    	//此处第一个参数为jdk路径+\\jre，第二个参数为jsp文件名称
    	CompileJsp.compileJsp("C:\\Program Files\\Java\\jdk1.8.0_101\\jre","test.jsp");
        Server server = new Server();
        System.out.println("服务器已启动...");
        //等待连接请求
        server.await();
    }

    public void await() {
        ServerSocket serverSocket = null;
        int port = 8080;
        try {
            //服务器套接字对象
            serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        // 循环等待请求
        while (true) {
            Socket socket = null;
            InputStream input = null;
            OutputStream output = null;
            try {
                //等待连接，连接成功后，返回一个Socket对象
                socket = serverSocket.accept();
                input = socket.getInputStream();
                output = socket.getOutputStream();

                // 创建Request对象并解析
                RequestImpl request = new RequestImpl(input);
                request.parse();
                // 检查是否是关闭服务命令
                if(request.getUri()!=null){
                    if (request.getUri().equals(SHUTDOWN_COMMAND)) {
                        break;
                    }
                    // 创建 Response 对象
                    ResponseImpl response = new ResponseImpl(output);
                    response.setRequest(request);

                    if (request.getUri().startsWith("/servlet/")) {
                    	//请求uri以/servlet/开头，表示servlet请求
                    	DynamicProcessor processor = new DynamicProcessor();
                        processor.process(request, response);
                    } else {
                        //静态资源请求
                        StaticProcessor processor = new StaticProcessor();
                        processor.process(request, response);
                    }
                }
            } catch (Exception e) {
            	System.out.println("NO RESOURCE");
                //e.printStackTrace();
                //System.exit(1);
            } finally{

                // 关闭 socket  
            	if(!socket.isClosed()){

                    try {
    					socket.close();
    				} catch (IOException e) {
    					e.printStackTrace();
    				}
            	}
            }
        }
    }
}
