package ladder.ladderexceptions;

public class InvalidLadderHeightException extends IllegalArgumentException {
    public InvalidLadderHeightException() {
        super("유효하지 않은 높이입니다.");
    }
}
