package exceptions;

public class BadChordQualityException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public BadChordQualityException(String message) {
		super(message);
	}

}
