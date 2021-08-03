package nextstep.ladder.exception;

public class IllegalLadderHeightException extends RuntimeException {
    public IllegalLadderHeightException(int height) {
        super("사다리의 높이는 0보다 큰 숫자여야 합니다. input===" + height);
    }
}
