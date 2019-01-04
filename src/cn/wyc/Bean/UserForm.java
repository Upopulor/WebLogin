package cn.wyc.Bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UserForm {
	//验证
	private int id;
	private String name;
	private String password;
	private String repassword;
	private String email;
	private String birthday;
	Map<String, String> msg = new HashMap<String,String>();
	public boolean validate() {
		if("".equals(name)) {
			msg.put("name", "用户名不能为空");
		}else if(!name.matches("\\w{3,8}")) {//用户名必须输入3-8位的字母
			msg.put("name", "用户名为3-8位的字母组成");
		}
		if("".equals(password)) {
			msg.put("password", "密码不能为空");
		}else if(!password.matches("\\d{3,8}")) {//用户名必须输入3-8位的字母
			msg.put("password", "密码为3-8位的数字");
		}
		if(!repassword.equals(password)) {
			msg.put("repassword", "重复密码不能为空");
		}
		if("".equals(email)) {
			msg.put("email", "email不能为空");
		}else if(!email.matches("\\b^['_a-z0-9-\\+]+(\\.['_a-z0-9-\\+]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*\\.([a-z]{2}|aero|arpa|asia|biz|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|nato|net|org|pro|tel|travel|xxx)$\\b")) {
			msg.put("email", "email格式不正确");
		}
		if("".equals(birthday)) {
			msg.put("birthday", "生日不能为空");
		}else  {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				sdf.parse(birthday);
			} catch (ParseException e) {
				msg.put("birthday", "生日格式不正确");
			}
		}
		return msg.isEmpty();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public Map<String, String> getMsg() {
		return msg;
	}
	public void setMsg(Map<String, String> msg) {
		this.msg = msg;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
}
