package jsphandle;

import java.io.File;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class CompileJsp {

	public static void compileJsp(String jrePath,String file){
		System.out.println("��ʼ����...");
		String newFile = file.replace(".", "_") + ".java";
		System.setProperty("java.home",jrePath);
		String path = System.getProperty("user.dir");
		//��̬����  
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();  
		int flag = compiler.run(null, null, null,"-d",path+File.separator+"\\bin",path+File.separator+"src/Servlet/"+newFile);  
		System.out.println(flag == 0 ? "����ɹ�..." : "����ʧ��...");
    } 
}
