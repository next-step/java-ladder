package nextstep.ladder.domain.info;

public class LadderSize {
    public static final int MIN = 1;

    private final int width;
    private final int height;

    public LadderSize(int width, int height) {
        validate(width, height);

        this.width = width;
        this.height = height;
    }

    private void validate(int width, int height) {
        if (width < MIN || height < MIN) {
            throw new IllegalArgumentException("Ladder Size는 최소값 " + MIN + " 보다 작을수 없습니다");
        }
    }

    public static LadderSize of(int width, int height) {
        return new LadderSize(width, height);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isMinWidth() {
        return width == MIN;
    }
}
