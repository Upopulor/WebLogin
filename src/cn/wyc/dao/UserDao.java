package cn.wyc.dao;

import cn.wyc.Bean.users;

public interface UserDao {
	//����û���Ϣ
	public void addUser(users user) throws Exception;
	//��¼����
	public users findUser(users user);
	//�����û��������û��Ƿ����
	public boolean findUserByName(String name);
}
