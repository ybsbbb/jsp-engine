package filehandle;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 将解析后的JSP文件写入文件
 * @author yb775802151
 *
 */
public class FileWrite {
	
	public static void writeFile(String filename,String content)
    {
		System.out.println("写入JAVA文件...");
        try
        {
        	String path=System.getProperty("user.dir")+File.separator+"src"+File.separator+
        			"Servlet"+File.separator+filename;
        	File file=new File(path);
        	if(!file.exists())
        		file.createNewFile();
        	FileOutputStream out=new FileOutputStream(file,false);
        	out.write(content.getBytes("utf-8"));
        	out.close();
        	System.out.println("写入完毕...");
        }
        catch(IOException ex){
        	System.out.println(ex.getStackTrace());
        }
    } 
}
