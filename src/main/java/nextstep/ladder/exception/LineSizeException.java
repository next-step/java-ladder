package nextstep.ladder.exception;

public class LineSizeException extends RuntimeException {

    public LineSizeException() {
        super("사다리의 너비는 1보다 커야합니다.");
    }
}
