package filehandle;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ���������JSP�ļ�д���ļ�
 * @author yb775802151
 *
 */
public class FileWrite {
	
	public static void writeFile(String filename,String content)
    {
		System.out.println("д��JAVA�ļ�...");
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
        	System.out.println("д�����...");
        }
        catch(IOException ex){
        	System.out.println(ex.getStackTrace());
        }
    } 
}
