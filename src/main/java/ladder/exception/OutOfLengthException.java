package ladder.exception;

public class OutOfLengthException extends IllegalArgumentException {

    public OutOfLengthException(String name) {
        super("최대 길이를 벗어났습니다 : " + name);
    }
}
