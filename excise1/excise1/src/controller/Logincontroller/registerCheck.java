package controller.Logincontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.UserDao;

@WebServlet(urlPatterns = "/registerCheck.do")
public class registerCheck extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String flag = request.getParameter("flag");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String charName = userName;
		UserDao dao = new UserDao();
		boolean test = false;
		Map<String,Object>map = new HashMap<String,Object>();
		
		if("true".equals(flag)){
			test = dao.add(userName, password, charName);
			map.put("flag", test+"");
		}else{
			map.put("flag", "false");
		}
		
		String jsonStr = new Gson().toJson(map);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonStr);
		out.flush();
		out.close();
		
	}

}
