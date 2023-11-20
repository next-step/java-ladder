package nextstep.ladder.exception;

public class LadderHeightSizeException extends RuntimeException {

    public LadderHeightSizeException() {
        super("사다리의 높이는 1보다 커야합니다.");
    }
}
