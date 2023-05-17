package ladder.exception;

public class IllegalAdjacentVerticalLinesException extends RuntimeException {
    private static final String DEFAULT_MESSAGE = "인덱스의 차이가 2 이상인 인접하지 않은 VerticalLine으로 생성할 수 없습니다.";

    public IllegalAdjacentVerticalLinesException(String message) {
        super(String.format("%s %s", DEFAULT_MESSAGE, message));
    }
}
