package ladder.ladderexceptions;

public class InvalidRewardNameException extends IllegalArgumentException {
    public InvalidRewardNameException() {
        super("상금 형식에 맞지 않습니다.");
    }
}
