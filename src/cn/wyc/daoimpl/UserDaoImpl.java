package cn.wyc.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.management.RuntimeErrorException;

import cn.wyc.Bean.users;
import cn.wyc.dao.UserDao;
import cn.wyc.utils.DBUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public void addUser(users user) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("INSERT INTO users(id,name,password,email,birthday) VALUES(?,?,?,?,?)");
			ps.setInt(1, user.getId());
			ps.setString(2, user.getName());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getEmail());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String date = sdf.format(user.getBirthday());
			ps.setString(5, date);
			int i = ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("ÃÌº” ß∞‹");
		}finally {
			DBUtils.closeAll(null, ps, conn);
		}	
	}

	@Override
	public users findUser(users user)  {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		users u = null;
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("select * from users where name=? and password=?");
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			rs = ps.executeQuery();
			if(rs.next()) {
				u = new users();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setBirthday(rs.getDate(5));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(rs, ps, conn);
		}
		return u;
	}

	@Override
	public boolean findUserByName(String name) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("select * from users where name=?");
			ps.setString(1, name);
			rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(rs, ps, conn);
		}
		return false;
	}
}
