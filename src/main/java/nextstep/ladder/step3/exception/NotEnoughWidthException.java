package nextstep.ladder.step3.exception;

public class NotEnoughWidthException extends IllegalArgumentException {

    private static final String MESSAGE = "사다리 게임을 위해서는 라인은 최소 (%d) 이상 이어야 합니다.";

    public NotEnoughWidthException(int size) {
        super(String.format(MESSAGE, size));
    }

}
