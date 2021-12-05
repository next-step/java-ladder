package ladder.domain;

import java.util.Objects;

public class Height {
    private static final String HEIGHT_ERROR_MESSAGE = "error : 높이는 최소%d, 최대%d 까지 가능합니다.";
    private static final int MIN = 2;
    private static final int MAX = 10;
    private final int height;

    public Height(int height) {
        validHeight(height);
        this.height = height;
    }

    private void validHeight(int height){
        if(height < MIN || height > MAX){
            throw new IllegalArgumentException(String.format(HEIGHT_ERROR_MESSAGE, MIN, MAX));
        }
    }

    public int value() {
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
}
