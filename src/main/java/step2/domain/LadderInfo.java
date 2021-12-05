package step2.domain;

import java.util.Objects;

public class LadderInfo {
    public static final int MIN_NUMBER = 0;

    private final Width width;
    private final Height height;

    private LadderInfo(Width width, Height height) {
        this.width = width;
        this.height = height;
    }

    public static LadderInfo of(int width, int height) {
        validate(width);
        validate(height);
        return new LadderInfo(Width.of(width), Height.of(height));
    }

    public int getWidth() {
        return width.getWidth();
    }

    public int getHeight() {
        return height.getHeight();
    }

    private static void validate(int number) {
        if (number < MIN_NUMBER) {
            throw new IllegalArgumentException("음수는 허용하지 않습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderInfo that = (LadderInfo) o;
        return Objects.equals(width, that.width) &&
                Objects.equals(height, that.height);
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }
}
