package ladder.domain;

public class PlayerNameLengthException extends RuntimeException {
    public static final String MESSAGE = "참가자 이름은 5글자 이상을 입력할 수 없습니다.";

    public PlayerNameLengthException() {
        super(MESSAGE);
    }
}
