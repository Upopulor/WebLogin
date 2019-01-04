package cn.wyc.dao;

import cn.wyc.Bean.users;

public interface UserDao {
	//添加用户信息
	public void addUser(users user) throws Exception;
	//登录操作
	public users findUser(users user);
	//根据用户名查找用户是否存在
	public boolean findUserByName(String name);
}
