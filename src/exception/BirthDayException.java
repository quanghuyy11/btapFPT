package exception;

public class BirthDayException extends RuntimeException{
    public BirthDayException() {
        super();
    }

    public BirthDayException(String message) {
        super(message);
    }

    public BirthDayException(String message, Throwable cause) {
        super(message, cause);
    }

    public BirthDayException(Throwable cause) {
        super(cause);
    }

    protected BirthDayException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
