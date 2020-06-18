package ladder.domain;

public class PlayerNameMismatchException extends RuntimeException {
    public static final String MESSAGE = "존재하지 않는 참가자 입니다.";

    public PlayerNameMismatchException() {
        super(MESSAGE);
    }
}
