package filehandle;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 从根目录读取指定的文件
 * @author yb775802151
 *
 */

public class FileRead {

	//将jsp文件读取至内存，储存在result字符串中并返回
	public static String readFile(String fileName) {
		StringBuffer sb = new StringBuffer();
		BufferedReader reader = null;
        try {
            System.out.println("读取JSP文件...");
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
            String tempString = null;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
            	sb.append(tempString);
            }
            reader.close();
            System.out.println("读取完毕...");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        
        return sb.toString();
    }

}
