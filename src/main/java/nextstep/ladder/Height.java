package nextstep.ladder;

import java.util.Objects;

public class Height {

    private final int height;

    public Height(int height) {
        validateHeight(height);
        this.height = height;
    }

    public Height(String height) {
        this(Integer.parseInt(height));
    }

    private void validateHeight(int height) {
        if (height < 2) {
            throw new IllegalArgumentException("사다리 높이는 2 이상이어야 합니다.");
        }
    }

    public int height() {
        return height;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Height height1 = (Height) obj;
        return height == height1.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }
}
