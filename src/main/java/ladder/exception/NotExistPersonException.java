package ladder.exception;

public class NotExistPersonException extends RuntimeException {
    private NotExistPersonException() {
        super("존재하지 않는 사람입니다.");
    }

    public static NotExistPersonException getInstance() {
        return SingletonHelper.instance;
    }

    private static class SingletonHelper {
        private static final NotExistPersonException instance = new NotExistPersonException();
    }
}
