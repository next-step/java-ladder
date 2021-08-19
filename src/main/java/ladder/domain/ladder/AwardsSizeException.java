package ladder.domain.ladder;

public class AwardsSizeException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "상금은 2개 이상이어야 합니다.";

    public AwardsSizeException() {
        super(DEFAULT_MESSAGE);
    }
}
