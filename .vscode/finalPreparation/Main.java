public class Main {
    public static void main(String[] args) {
        ScreenSizeOutOfBoundsException test = new ScreenSizeOutOfBoundsException();
        System.out.println(test.getMessage());
    }

}

class ScreenSizeOutOfBoundsException extends RuntimeException {
    public String getMessage() {
        return "screen size is out of bounds";
    }
}

class TurnOnModeException extends RuntimeException {
    public TurnOnModeException() {
        super("The device is already on!");
    }
}
