package step1.domain;

public class Height {

    private final int height;

    public Height(int height) {
        validateHeight(height);
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public boolean isEqualsHeight(int height) {
        return this.height == height;
    }

    public boolean isEqualsHeight(Height height) {
        return isEqualsHeight(height.getHeight());
    }

    private void validateHeight(int height) {
        if (height < 1) {
            throw new IllegalArgumentException("높이는 1 미만일 수 없습니다.");
        }
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
