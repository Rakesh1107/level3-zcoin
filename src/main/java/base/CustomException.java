package base;

public class CustomException extends Throwable {

	private static final long serialVersionUID = 1L;
	
	String message;

    public CustomException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
