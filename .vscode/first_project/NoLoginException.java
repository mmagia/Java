public class NoLoginException extends Exception {
    public NoLoginException() {
        super("Can not record without login!");
    }
}
