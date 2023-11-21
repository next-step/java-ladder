package ladder.domain;

import java.util.Objects;

public class Height implements Comparable<Height>{

    private int height;

    public Height(int height) {
        inputValidation(height);
        this.height = height;
    }

    private void inputValidation(int height) {
        if(height < 1){
            throw new IllegalArgumentException("높이는 1 이상이어야 합니다.");
        }
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
    public int compareTo(Height o) {
        return Integer.compare(height, o.height);
    }
}
