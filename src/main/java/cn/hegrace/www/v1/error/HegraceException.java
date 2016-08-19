package cn.hegrace.www.v1.error;

public class HegraceException {
	
	private String exception;
	
	public HegraceException(String exception){
		this.exception = exception;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}



}
