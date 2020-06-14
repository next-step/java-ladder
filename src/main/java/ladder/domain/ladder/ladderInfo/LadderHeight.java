package ladder.domain.ladder.ladderInfo;

public class LadderHeight {
    private final int height;

    private LadderHeight(int height) {
        this.height = height;
    }

    public static LadderHeight inputHeight(final int height) {
        validateHeight(height);
        return new LadderHeight(height);
    }

    private static void validateHeight(int height) {
        if (height < 1) {
            throw new IllegalArgumentException("높이는 1 보다 작을 수 없습니다.");
        }
    }

    public int getHeight() {
        return height;
    }
}
