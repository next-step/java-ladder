package step4.domain;

import java.util.Objects;

public class LadderInfo {
    private final Width width;
    private final Height height;

    private LadderInfo(Width width, Height height) {
        this.width = width;
        this.height = height;
    }

    public static LadderInfo of(int width, int height) {
        return new LadderInfo(Width.of(width), Height.of(height));
    }

    public int width() {
        return width.width();
    }

    public int height() {
        return height.height();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderInfo that = (LadderInfo) o;
        return Objects.equals(width, that.width) && Objects.equals(height, that.height);
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }
}
