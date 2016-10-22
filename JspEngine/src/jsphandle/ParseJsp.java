package jsphandle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import filehandle.FileRead;
import filehandle.FileWrite;
import filehandle.ServletFileConstruct;

public class ParseJsp {

	String jspContent = FileRead.readFile("WebContent/test.jsp");	
	String afterParse = "";
	String left = "\nout.println(\"";
	String right = "\");\n";
	
	private void removePageInfo(){
		int index = jspContent.indexOf("<%@");
		if(index!=-1){
			index = jspContent.indexOf("%>");
			jspContent = jspContent.substring(index+2);
		}
	}
	private void handle_0(){
		int index = jspContent.indexOf("<%=");
		String first = "";
		String second = "";
		List<String> list = new ArrayList<String>();
		while(index!=-1){
			first = jspContent.substring(0,index);
			second = jspContent.substring(index);
			first = first.replace("\"", "\\\"");
			list.add(first);
			int i = second.indexOf("%>");
			first = second.substring(0, i+2);
			list.add(first);
			jspContent = second.substring(i+2);
			index = jspContent.indexOf("<%=");
		}
		list.add(jspContent);
		StringBuffer sb = new StringBuffer();
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			sb.append(it.next());
		}
		jspContent = sb.toString();
		
	}
	private boolean handle_1(){
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		int index = jspContent.indexOf("<%=");
		if(index == -1){
			return false;
		}
		sb1.append(jspContent.substring(0,index));
		sb1.append("<%out.println(");
		sb1.append(jspContent.substring(index+3));
		jspContent = sb1.toString();
		
		index = jspContent.indexOf("%>",index);
		sb2.append(jspContent.substring(0,index));
		sb2.append(");");
		sb2.append(jspContent.substring(index));
		jspContent = sb2.toString();
		
		return true;
	}
	private void handle_2(){
		String[] lines1 = jspContent.split("<%");
		StringBuffer sb1 = new StringBuffer();
		for(int i=0;i<lines1.length;i++){
			sb1.append(lines1[i]);
			sb1.append(right);
		}
		jspContent = sb1.toString();
		

		String[] lines2 = jspContent.split("%>");
		StringBuffer sb2 = new StringBuffer();
		for(int i=0;i<lines2.length;i++){
			sb2.append(left);
			sb2.append(lines2[i]);
		}
		jspContent = sb2.toString();
	}
	private void handle_3(){
		jspContent = jspContent.replace("out.println(\"\");", "");
	}
	//public static void main(String[] args){
	public static void parseJsp(String filename){
		String ServletName = filename.replace(".", "_");
		String newName = ServletName+".java";
		System.out.println("Jsp文件转换开始...");
		FileRead.readFile("WebContent/"+filename);
		ParseJsp pjsp = new ParseJsp();
		pjsp.removePageInfo();
		pjsp.handle_0();
		do{
		}while(pjsp.handle_1());
		pjsp.handle_2();
		pjsp.handle_3();
    	StringBuffer sb=new StringBuffer();
    	sb.append(ServletFileConstruct.getAttr("packageLines"));
    	sb.append(ServletFileConstruct.getAttr("importLines"));
    	sb.append("\n");
    	sb.append(ServletFileConstruct.getAttr("classLines").replace("TestServlet", ServletName)+"{");
    	sb.append("\n");
    	sb.append(ServletFileConstruct.getAttr("build_inLines"));
    	sb.append("\n");
    	sb.append(ServletFileConstruct.getAttr("serviceLines")+"{\n"+
    			ServletFileConstruct.getAttr("serviceCodeLines")+pjsp.jspContent+"\n}");
    	sb.append("\n");
    	sb.append(ServletFileConstruct.getAttr("otherLines")+"\n}");
    	FileWrite.writeFile(newName, sb.toString());
    	System.out.println("Jsp文件已转为Java文件...");
    	
	}
}
