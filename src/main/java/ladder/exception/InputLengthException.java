package ladder.exception;

public class InputLengthException extends LadderException {

    public InputLengthException(int length) {
        super("사람 이름은 최대 " + length + "글자까지 부여할 수 있습니다.");
    }
}
