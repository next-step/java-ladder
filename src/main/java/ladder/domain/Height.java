package ladder.domain;

import java.util.Objects;

public class Height {

    private final int height;

    public Height(int height) {
        if (height < 1) {
            throw new IllegalArgumentException("높이는 1이상 입력해주세요");
        }
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Height height1 = (Height) o;
        return height == height1.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }

    @Override
    public String toString() {
        return height + "";
    }

}
