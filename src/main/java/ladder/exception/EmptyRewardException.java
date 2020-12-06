package ladder.exception;

public class EmptyRewardException extends IllegalArgumentException {
    public EmptyRewardException() {
        super("제공 될 보상을 입력해주세요.");
    }
}
