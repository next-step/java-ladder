package ladder.domain;

public class LadderInfo {

    private final int width;
    private final int height;

    private LadderInfo(int width, int height) {

        this.width = width;
        this.height = height;
    }

    public static LadderInfo of(int width, int height) {

        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("라인 개수 또는 길이가 유효하지 않습니다.");
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
