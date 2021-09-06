package ladder.exception;

public class LadderHeightException extends RuntimeException {
    private static final String LADDER_HEIGHT_EXCEPTION = "사다리 길이는 1 이상 으로 입력하세요 입력한 숫자 : %d";

    public LadderHeightException(int height) {
        super(String.format(LADDER_HEIGHT_EXCEPTION, height));
    }
}
