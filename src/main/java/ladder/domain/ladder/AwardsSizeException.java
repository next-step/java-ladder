package ladder.domain.ladder;

public class AwardsSizeException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "상금은 2개 이상이어야 합니다. 현재 상금 수 : %d";

    public AwardsSizeException(int sizeOfAwards) {
        super(String.format(DEFAULT_MESSAGE, sizeOfAwards));
    }
}
