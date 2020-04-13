package ladder.ladder.domain;

public class InvalidHeightException extends IllegalArgumentException {
    public InvalidHeightException() {
        super("높이는 1보다 커야 합니다.");
    }
}
