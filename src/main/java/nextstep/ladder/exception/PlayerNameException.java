package nextstep.ladder.exception;

public class PlayerNameException extends RuntimeException {
    private static final String MESSAGE = "이름은 1 ~ 5자 로 적어주세요. (입력값 = %s)";

    public PlayerNameException(String name) {
        super(String.format(MESSAGE, name));
    }
}
