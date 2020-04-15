package ladder.player.domain;

public class NotEnoughCountOfPersonException extends IllegalArgumentException {
    public NotEnoughCountOfPersonException() {
        super("사다리 게임을 하려면 최소 2명 이상이어야 합니다.");
    }
}
