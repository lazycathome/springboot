package cn.bigdb.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MyExceptionResponse {

	private int code;
	private String msg;
}
