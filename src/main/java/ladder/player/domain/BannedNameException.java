package ladder.player.domain;

public class BannedNameException extends IllegalArgumentException {
    public BannedNameException() {
        super("'all'은 참여자로 등록 할 수 없습니다.");
    }
}
