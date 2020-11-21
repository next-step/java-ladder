package nextstep.ladder.domain.ladder;

public class InvalidDirectionException extends RuntimeException {
    private static final String MESSAGE = "양쪽 방향을 모두 가질수는 없습니다.";

    public InvalidDirectionException() {
        super(MESSAGE);
    }
}
