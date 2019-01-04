package cn.wyc.serviceimpl;

import cn.wyc.Bean.users;
import cn.wyc.dao.UserDao;
import cn.wyc.daoimpl.UserDaoImpl;
import cn.wyc.exception.UserExitException;
import cn.wyc.exception.UsersException;
import cn.wyc.service.UserService;

public class UserServiceImpl implements UserService {

	UserDao userDao = new UserDaoImpl();
	@Override
	public void register(users user) throws Exception {
		// TODO Auto-generated method stub
		userDao.addUser(user);
	}
	@Override
	public users login(users user) throws UsersException{
		// TODO Auto-generated method stub
		users u = null;
		try {
			u = userDao.findUser(user);
			if(u==null) {
				throw new UsersException("�û��������벻��ȷ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//д����־		
		}
		return u;
	}
	@Override
	public boolean findUserByName(String name) throws UserExitException {
		// TODO Auto-generated method stub
		boolean b = userDao.findUserByName(name);
		if(b) {
			throw new UserExitException("�û��Ѵ���");
		}
		return b;
	}
}
