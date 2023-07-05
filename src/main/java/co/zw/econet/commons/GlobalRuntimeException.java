package co.zw.econet.commons;

public class GlobalRuntimeException extends RuntimeException{
    public GlobalRuntimeException(String message) {
        super(message);
    }

    public GlobalRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public GlobalRuntimeException(final Throwable cause) {
        super(cause);
    }
}
