package ladder.exception;

public class NoSuchLadderException extends LadderException {
    public NoSuchLadderException() {
        super("사다리가 존재하지 않습니다.");
    }
}
