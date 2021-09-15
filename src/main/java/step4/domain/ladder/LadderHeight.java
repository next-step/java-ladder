package step4.domain.ladder;

import step4.exception.ladder.LadderHeightException;

public class LadderHeight {

    private final int height;

    private LadderHeight(int height) {
        this.height = height;
    }

    public static LadderHeight of(int height) {
        checkLadderHeight(height);

        return new LadderHeight(height);
    }

    private static void checkLadderHeight(int height) {
        if (height < 1) {
            throw new LadderHeightException();
        }
    }

}
