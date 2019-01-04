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
		//��ȡ������
		UserForm uf = new UserForm();
		try {
			BeanUtils.populate(uf, request.getParameterMap());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(!uf.validate()) {//���map�в�Ϊ����˵���д�����Ϣ
			request.setAttribute("uf", uf);
			request.getRequestDispatcher("/reg.jsp").forward(request, response);
			return;
		}
		users user = new users();
		try {
			//������������ݻᱨ���޷���ӽ����ݿ⡣�������һ�²���
			/*ConvertUtils.register(new Converter() {//ע��һ������ת����
				
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
			}, Date.class);*///��Ȼ��ʵ�Ѿ����ֳɵģ�����
			
			ConvertUtils.register(new DateLocaleConverter(), Date.class);
			BeanUtils.populate(user, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		//����ҵ���߼�
		UserService us = new UserServiceImpl();
		try {
			//�鿴�û����Ƿ��ѱ�ע��
			us.findUserByName(user.getName());
		} catch (UserExitException e1) {
			// TODO Auto-generated catch block
			request.setAttribute("error", "�û����Ѵ���");
			request.getRequestDispatcher("reg.jsp").forward(request, response);	
		}
		try {
			us.register(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�ַ�ת��
		response.getWriter().write("ע��ɹ���1�����ת����ҳ");
		response.setHeader("refresh", "1;url="+request.getContextPath()+"/Login.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
