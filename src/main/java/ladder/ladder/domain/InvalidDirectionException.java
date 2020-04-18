package ladder.ladder.domain;

public class InvalidDirectionException extends IllegalArgumentException {
    public InvalidDirectionException() {
        super("왼쪽과 오른쪽이 동시에 연결 될 수 없습니다.");
    }
}
