package step4.domain;

public class Height {

    private final int height;

    public Height(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("height는 0이하의 값이 들어올 수 없습니다.");
        }

        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public boolean isSame(int height) {
        return this.height == height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Height)) {
            return false;
        }

        Height height1 = (Height) o;

        return height == height1.height;
    }

    @Override
    public int hashCode() {
        return height;
    }
}
