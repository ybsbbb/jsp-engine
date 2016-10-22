package filehandle;

import java.util.HashMap;
import java.util.Map;

/**
 * 构造Servlet文件的基本结构
 * 只能适应于我的测试项目
 * @author yb775802151
 *
 */
public class ServletFileConstruct {

	static Map<String,String> fileMap = new HashMap<String,String>();
	
	static String packageLines;
	static{
		packageLines = "package Servlet;";
	}
	static String importLines;
	static{
		importLines = "import java.io.IOException;import java.io.PrintWriter;import javax.servlet.Servlet;import javax.servlet.ServletConfig;import javax.servlet.ServletException;import javax.servlet.ServletRequest;import javax.servlet.ServletResponse;";
	}
	static String classLines;
	static{
		classLines = "public class TestServlet implements Servlet";
	}
	static String build_inLines;
	static{
		build_inLines = "ServletRequest request=null;ServletResponse response=null;";
	}
	static String serviceLines;
	static{
		serviceLines = "public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException";
	}
	static String serviceCodeLines;
	static{
		serviceCodeLines = "this.request=request;this.response=response;PrintWriter out=response.getWriter();";
	}
	static String otherLines;
	static{
		otherLines = "public void destroy(){}public ServletConfig getServletConfig(){return null;}public String getServletInfo(){return null;}public void init(ServletConfig arg0) throws ServletException {}";
	}
	static{
		fileMap.put("packageLines", packageLines);
		fileMap.put("importLines",importLines);
		fileMap.put("classLines", classLines);
		fileMap.put("build_inLines", build_inLines);
		fileMap.put("serviceLines", serviceLines);
		fileMap.put("serviceCodeLines", serviceCodeLines);
		fileMap.put("otherLines", otherLines);
	}
	public static String getAttr(String key){
		return fileMap.get(key);
	}

}
