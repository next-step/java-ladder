package ladder.domain.ladder;

public class LadderResultException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "참가자의 수와 상금의 수가 일치하지 않습니다.";

    public LadderResultException() {
        super(DEFAULT_MESSAGE);
    }
}
