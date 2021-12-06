package nextstep.ladder.exception;

public class LadderLengthException extends IllegalArgumentException {

    private static final String MESSAGE = "사다리 길이는 %d이상 이어야 합니다.";

    public LadderLengthException(int size) {
        super(String.format(MESSAGE, size));
    }

}
