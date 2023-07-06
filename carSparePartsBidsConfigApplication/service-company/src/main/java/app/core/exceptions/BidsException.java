package app.core.exceptions;

public class BidsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BidsException() {
	}

	public BidsException(String message) {
		super(message);
	}

	public BidsException(Throwable cause) {
		super(cause);
	}

	public BidsException(String message, Throwable cause) {
		super(message, cause);
	}

	public BidsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
