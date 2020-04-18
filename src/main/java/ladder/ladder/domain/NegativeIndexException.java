package ladder.ladder.domain;

public class NegativeIndexException extends IllegalArgumentException {
    public NegativeIndexException() {
        super("인덱스는 음수가 될 수 없습니다.");
    }
}
