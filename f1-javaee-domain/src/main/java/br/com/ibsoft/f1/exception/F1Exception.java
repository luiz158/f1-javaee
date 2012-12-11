package br.com.ibsoft.f1.exception;

public class F1Exception extends Exception {

	private static final long serialVersionUID = 1L;

	public F1Exception() {
		super();
	}

	public F1Exception(String message, Throwable cause) {
		super(message, cause);
	}

	public F1Exception(String message) {
		super(message);
	}

	public F1Exception(Throwable cause) {
		super(cause);
	}
}
