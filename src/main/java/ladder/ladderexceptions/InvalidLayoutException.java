package ladder.ladderexceptions;

public class InvalidLayoutException extends IllegalArgumentException {
    public InvalidLayoutException() {
        super("연속된 가로선은 허용되지 않습니다.");
    }
}
