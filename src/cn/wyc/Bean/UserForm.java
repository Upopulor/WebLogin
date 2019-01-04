package cn.wyc.Bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UserForm {
	//��֤
	private int id;
	private String name;
	private String password;
	private String repassword;
	private String email;
	private String birthday;
	Map<String, String> msg = new HashMap<String,String>();
	public boolean validate() {
		if("".equals(name)) {
			msg.put("name", "�û�������Ϊ��");
		}else if(!name.matches("\\w{3,8}")) {//�û�����������3-8λ����ĸ
			msg.put("name", "�û���Ϊ3-8λ����ĸ���");
		}
		if("".equals(password)) {
			msg.put("password", "���벻��Ϊ��");
		}else if(!password.matches("\\d{3,8}")) {//�û�����������3-8λ����ĸ
			msg.put("password", "����Ϊ3-8λ������");
		}
		if(!repassword.equals(password)) {
			msg.put("repassword", "�ظ����벻��Ϊ��");
		}
		if("".equals(email)) {
			msg.put("email", "email����Ϊ��");
		}else if(!email.matches("\\b^['_a-z0-9-\\+]+(\\.['_a-z0-9-\\+]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*\\.([a-z]{2}|aero|arpa|asia|biz|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|nato|net|org|pro|tel|travel|xxx)$\\b")) {
			msg.put("email", "email��ʽ����ȷ");
		}
		if("".equals(birthday)) {
			msg.put("birthday", "���ղ���Ϊ��");
		}else  {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				sdf.parse(birthday);
			} catch (ParseException e) {
				msg.put("birthday", "���ո�ʽ����ȷ");
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
