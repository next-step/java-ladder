package ladder.domain;

public class LadderInfo {

    private static final int MIN_WIDTH = 2;
    private static final int MIN_HEIGHT = 1;
    private final int width;
    private final int height;

    private LadderInfo(int width, int height) {

        this.width = width;
        this.height = height;
    }

    public static LadderInfo of(int width, int height) {

        if (width < MIN_WIDTH || height < MIN_HEIGHT) {
            throw new IllegalArgumentException("참가자 수 또는 길이가 유효하지 않습니다.");
        }

        return new LadderInfo(width, height);
    }

    public int getWidth() {

        return width;
    }

    public int getHeight() {

        return height;
    }
}
