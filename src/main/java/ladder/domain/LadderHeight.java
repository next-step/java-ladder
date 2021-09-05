package ladder.domain;

import ladder.exception.LadderHeightException;

public class LadderHeight {
    private static final int MIN_HEIGHT = 1;
    
    private final int height;

    public LadderHeight(int height) {
        validateHeight(height);
        this.height = height;
    }

    private void validateHeight(int height) {
        if (height < MIN_HEIGHT) {
            throw new LadderHeightException(height);
        }
    }

    public int toInt() {
        return height;
    }
}
