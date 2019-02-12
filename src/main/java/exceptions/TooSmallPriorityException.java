package exceptions;

public class TooSmallPriorityException extends Exception {
    public TooSmallPriorityException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
