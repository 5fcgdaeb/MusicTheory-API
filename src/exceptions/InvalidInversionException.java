package exceptions;

public class InvalidInversionException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public InvalidInversionException(String message) {
		super(message);
	}
}
