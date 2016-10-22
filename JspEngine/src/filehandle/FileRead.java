package filehandle;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * �Ӹ�Ŀ¼��ȡָ�����ļ�
 * @author yb775802151
 *
 */

public class FileRead {

	//��jsp�ļ���ȡ���ڴ棬������result�ַ����в�����
	public static String readFile(String fileName) {
		StringBuffer sb = new StringBuffer();
		BufferedReader reader = null;
        try {
            System.out.println("��ȡJSP�ļ�...");
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
            String tempString = null;
            // һ�ζ���һ�У�ֱ������nullΪ�ļ�����
            while ((tempString = reader.readLine()) != null) {
            	sb.append(tempString);
            }
            reader.close();
            System.out.println("��ȡ���...");
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
