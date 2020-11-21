package ladder.exception;

public class BadResultsException extends RuntimeException {
    private BadResultsException() {
        super("결과의 갯수는 사람의 명수와 같아야 합니다.");
    }

    public static BadResultsException getInstance() {
        return SingletonHelper.instance;
    }

    private static class SingletonHelper {
        private static final BadResultsException instance = new BadResultsException();
    }
}
