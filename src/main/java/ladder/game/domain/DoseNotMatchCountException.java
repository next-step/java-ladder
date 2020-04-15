package ladder.game.domain;

public class DoseNotMatchCountException extends IllegalArgumentException {
    public DoseNotMatchCountException() {
        super("참여자와 결과의 수가 같아야 합니다.");
    }
}
