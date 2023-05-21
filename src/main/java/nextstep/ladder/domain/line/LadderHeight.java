package nextstep.ladder.domain.line;

import java.util.stream.IntStream;

public class LadderHeight {

    private static final int START = 0;
    private static final String INVALID_LADDER_HEIGHT = "사다리의 높이는 1이상이여야 합니다.";

    private final int height;

    public LadderHeight(int height) {
        validate(height);
        this.height = height;
    }

    public IntStream toStream() {
        return IntStream.range(START, height);
    }

    private void validate(int height) {
        if (height < 1) {
            throw new IllegalArgumentException(INVALID_LADDER_HEIGHT);
        }
    }
}
