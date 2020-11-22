package ladder.exception;

public class ConsecutiveDirectionException extends RuntimeException {
    private ConsecutiveDirectionException() {
        super("LEFT 혹은 RIGHT direction 은 연속할 수 없다.");
    }

    public static ConsecutiveDirectionException getInstance() {
        return SingletonHelper.instance;
    }

    private static class SingletonHelper {
        private static final ConsecutiveDirectionException instance = new ConsecutiveDirectionException();
    }
}
