public class UnknownProductException extends RuntimeException {
    public UnknownProductException(String errorMessage) {
        super(errorMessage);
    }

    public UnknownProductException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}