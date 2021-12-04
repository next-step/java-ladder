package nextstep.ladder.domain.ladder.size;

public class LadderHeight {

    private static final int MIN_HEIGHT = 1;

    private final int height;

    public LadderHeight(int height) {
        checkHeight(height);
        this.height = height;
    }

    private void checkHeight(int height) {
        if (height < MIN_HEIGHT) {
            throw new TooShortException();
        }
    }

    public int getHeight() {
        return height;
    }
}
