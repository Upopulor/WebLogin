package cn.wyc.service;

import cn.wyc.Bean.users;
import cn.wyc.exception.UserExitException;
import cn.wyc.exception.UsersException;

public interface UserService {
	public void register(users user) throws Exception;
	public users login(users user)throws UsersException;
	public boolean findUserByName(String name) throws UserExitException;
}
