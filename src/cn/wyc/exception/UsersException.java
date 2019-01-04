package cn.wyc.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

public class UsersException extends Exception{

	public UsersException(String msg) {
		super(msg);
	}

	public UsersException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsersException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UsersException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UsersException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
