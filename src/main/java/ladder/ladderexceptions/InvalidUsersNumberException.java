package ladder.ladderexceptions;

public class InvalidUsersNumberException extends IllegalArgumentException {
    public InvalidUsersNumberException() {
        super("최소 1인 이상의 사용자가 필요합니다.");
    }
}
