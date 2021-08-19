package ladder.domain.ladder;

public class AwardNameException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "상금은 1~5자만 가능합니다.";

    public AwardNameException() {
        super(DEFAULT_MESSAGE);
    }
}
