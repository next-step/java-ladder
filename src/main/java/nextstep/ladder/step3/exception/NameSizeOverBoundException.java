package nextstep.ladder.step3.exception;

public class NameSizeOverBoundException extends IllegalArgumentException {

    private static final String MESSAGE = "이름의 최대 길이(%d)를 초과할 수 없습니다.";

    public NameSizeOverBoundException(int maximumSize) {
        super(String.format(MESSAGE, maximumSize));
    }

}
