package exceptions;

public class EmptyQueueException extends Exception {
    public EmptyQueueException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
