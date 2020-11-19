package ladder.exception;

public class BadNameException extends RuntimeException {
    private BadNameException() {
        super("이름은 5글자가 넘어서는 안됩니다.");
    }

    public static BadNameException getInstance() {
        return SingletonHelper.instance;
    }

    private static class SingletonHelper {
        private static final BadNameException instance = new BadNameException();
    }
}
