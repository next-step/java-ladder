package ladder.exception;


public class LengthNameException extends IllegalArgumentException {
    private static final Integer MAX_LENGTH = 5;

    public LengthNameException() {
        super("참여할 사람 이름 최대 길이는 " + MAX_LENGTH + "글자 입니다.");
    }
}
