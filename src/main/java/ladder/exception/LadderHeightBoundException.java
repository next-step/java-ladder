package ladder.exception;

public class LadderHeightBoundException extends LadderException {
    public LadderHeightBoundException(int LADDER_HEIGHT_MIN) {
        super("사다리 높이는 " + LADDER_HEIGHT_MIN + "이상이어야 합니다.");
    }
}
