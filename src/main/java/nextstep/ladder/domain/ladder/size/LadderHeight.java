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
            throw new LadderSizeException("사다리가 너무 짧습니다.");
        }
    }

    public int getHeight() {
        return height;
    }
}
