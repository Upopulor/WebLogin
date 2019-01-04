package cn.wyc.Servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import cn.wyc.Bean.UserForm;
import cn.wyc.Bean.users;
import cn.wyc.exception.UserExitException;
import cn.wyc.service.UserService;
import cn.wyc.serviceimpl.UserServiceImpl;

/**
 * Servlet implementation class regServlet
 */
@WebServlet("/regServlet")
public class regServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//获取表单数据
		UserForm uf = new UserForm();
		try {
			BeanUtils.populate(uf, request.getParameterMap());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(!uf.validate()) {//如果map中不为空则说明有错误信息
			request.setAttribute("uf", uf);
			request.getRequestDispatcher("/reg.jsp").forward(request, response);
			return;
		}
		users user = new users();
		try {
			//如果有日期数据会报错，无法添加进数据库。所以添加一下操作
			/*ConvertUtils.register(new Converter() {//注册一个日期转换器
				
				@Override
				public Object convert(Class type, Object value) {
					// TODO Auto-generated method stub
					Date data1 = null;
					if(value instanceof String) {
						String date = (String) value;
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						
						try {
							data1=sdf.parse(date);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					return data1;
				}
			}, Date.class);*///当然其实已经有现成的，如下
			
			ConvertUtils.register(new DateLocaleConverter(), Date.class);
			BeanUtils.populate(user, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		//调用业务逻辑
		UserService us = new UserServiceImpl();
		try {
			//查看用户名是否已被注册
			us.findUserByName(user.getName());
		} catch (UserExitException e1) {
			// TODO Auto-generated catch block
			request.setAttribute("error", "用户名已存在");
			request.getRequestDispatcher("reg.jsp").forward(request, response);	
		}
		try {
			us.register(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//分发转向
		response.getWriter().write("注册成功！1秒后跳转到主页");
		response.setHeader("refresh", "1;url="+request.getContextPath()+"/Login.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
