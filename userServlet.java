package com.test.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.dao.userDao;
import com.test.entity.userEntity;
import com.test.service.userService;



@WebServlet("/userServlet")
public class userServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public userServlet() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession(true);
		
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		
		userEntity userentity = new userEntity();
		userentity.setUserName(userName);
		userentity.setPassWord(passWord);
		
		
		userService userservice = new userService();
		
//		if(userservice.findByuserName(userentity)) {
//			userDao userdao = new userDao();
//			userdao.findByuserName(userName, passWord);
//			session.setAttribute("userentity", userentity);
//		}
			
			
		userEntity userlist = (userEntity) userservice.findByuserName(userName, passWord);
		System.out.println(userName+" "+passWord);
		if(userlist==null) {
			request.getRequestDispatcher("/Fall.jsp").forward(request,response);
			
		}
		else {
			request.setAttribute("userlist",userlist);
			request.getRequestDispatcher("/success.jsp").forward(request,response);
		}
	}

}
