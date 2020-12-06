package ladder.exception;

public class EmptyNameException extends IllegalArgumentException {
    public EmptyNameException() {
        super("참여할 사람 이름을 입력해주세요.");
    }
}
