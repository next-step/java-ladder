package nextstep.ladder.Model;

import java.util.Objects;

public class Height {

    private static final int POSITIVE_STANDARD = 0;
    private static final String HEIGHT_IS_POSITIVE = "높이는 양의 정수만 가능합니다.";
    private final int height;

    public Height(int height) {
        validate(height);
        this.height = height;
    }

    private void validate(int height) {
        if (isNegative(height)) {
            throw new IllegalArgumentException(HEIGHT_IS_POSITIVE);
        }
    }

    private boolean isNegative(int height) {
        return height < POSITIVE_STANDARD;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Height)) return false;
        Height height1 = (Height) o;
        return getHeight() == height1.getHeight();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHeight());
    }

}
