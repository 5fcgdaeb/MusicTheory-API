package exceptions;

public class InvalidScaleException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public InvalidScaleException(String message) {
		super(message);
	}
}
