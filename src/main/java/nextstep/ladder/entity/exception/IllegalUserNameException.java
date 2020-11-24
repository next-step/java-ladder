package nextstep.ladder.entity.exception;

public class IllegalUserNameException extends RuntimeException {

    private static final String message = "사용자 이름은 빈 공백이거나 5자를 초과하여 입력할 수 없습니다.";

    public IllegalUserNameException(String name) {
        super(String.format("%s (name = %s)", message, name));
    }
}
