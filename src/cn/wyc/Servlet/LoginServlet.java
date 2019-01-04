package cn.wyc.Servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.wyc.Bean.users;
import cn.wyc.exception.UsersException;
import cn.wyc.service.UserService;
import cn.wyc.serviceimpl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		users user = new users();
		
			try {
				BeanUtils.populate(user, request.getParameterMap());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			UserService us = new UserServiceImpl();
			users user1;
			try {
				user1 = us.login(user);
			
				//分发转向
				if(user1!=null) {
					request.getSession().setAttribute("u", user);
					request.getRequestDispatcher("/Login.jsp").forward(request, response);
				}
					
				
			} catch (UsersException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("msg", e.getMessage());
				request.getRequestDispatcher("/Login.jsp").forward(request, response);
				
			}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
