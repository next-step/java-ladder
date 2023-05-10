package nextstep.ladder.domain.ladder;

public class LadderHeight {

    private static final int MINIMUM_HEIGHT = 1;

    private final int height;

    private LadderHeight(int height) {
        this.height = height;
    }

    public static LadderHeight from(int height) {
        validate(height);
        return new LadderHeight(height);
    }

    private static void validate(int height) {
        if (height < MINIMUM_HEIGHT) {
            throw new IllegalArgumentException(String.format("높이는 최소 %d 이상 이어야 합니다.", MINIMUM_HEIGHT));
        }
    }

    public int getHeight() {
        return height;
    }

}
