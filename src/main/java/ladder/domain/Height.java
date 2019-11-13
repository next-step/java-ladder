package ladder.domain;

public class Height {

    private static final String ILLEGAL_HEIGHT = "유효하지 않은 높이입니다.";
    private static final int MIN_HEIGHT = 2;
    private final int height;

    private Height(int heightInput) {
        this.height = checkHeight(heightInput);
    }

    public static Height of(int height) {
        return new Height(height);
    }

    private int checkHeight(int heightInput) {
        if (heightInput < MIN_HEIGHT) {
            throw new IllegalArgumentException(ILLEGAL_HEIGHT);
        }
        return heightInput;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
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
