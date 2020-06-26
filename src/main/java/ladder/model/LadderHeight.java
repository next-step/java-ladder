package ladder.model;

public class LadderHeight {

    private static final int ZERO = 0;

    private int height;

    private LadderHeight(final int height) {
        if (height <= ZERO) {
            throw new IllegalArgumentException("사다리의 높이는 최소 1 이상 입니다.");
        }

        this.height = height;
    }

    public static LadderHeight create(final int height) {
        return new LadderHeight(height);
    }

    public int getHeight() {
        return height;
    }

}
