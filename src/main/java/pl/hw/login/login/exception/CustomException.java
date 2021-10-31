package pl.hw.login.login.exception;

public class CustomException extends Exception{
    public CustomException(String message, Throwable error) {
        super(message, error);
    }

    public CustomException(String message) {
        super(message);
    }

}
