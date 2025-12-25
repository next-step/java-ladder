package nextstep.ladder.domain.ladder;

import java.util.Objects;

public class Height {

    public static final int MIN_HEIGHT = 1;

    private int height;

    public Height(int height) {
        validateHeight(height);
        this.height = height;
    }

    private void validateHeight(int height) {
        if(height < MIN_HEIGHT){
            throw new IllegalArgumentException(String.format("높이는 %d보다 작을 수 없습니다.", MIN_HEIGHT));
        }
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Height height1 = (Height) o;
        return getHeight() == height1.getHeight();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getHeight());
    }
}
