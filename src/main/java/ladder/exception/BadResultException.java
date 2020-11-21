package ladder.exception;

public class BadResultException extends RuntimeException {
    private BadResultException() {
        super("결과는 5글자가 넘어서는 안됩니다.");
    }

    public static BadResultException getInstance() {
        return SingletonHelper.instance;
    }

    private static class SingletonHelper {
        private static final BadResultException instance = new BadResultException();
    }
}
