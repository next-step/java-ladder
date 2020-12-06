package ladder.exception;

public class MinimumNumberOfPersonException extends IllegalArgumentException {
    private static final Integer MIN_NUMBER = 2;

    public MinimumNumberOfPersonException() {
        super("참여하는 사람은 최소" + MIN_NUMBER + "명입니다.");
    }
}
