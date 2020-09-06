package step2.model;

public class Height {
    private final int height;

    public Height(int value) {
        validateParameter(value);
        this.height = value;
    }

    private void validateParameter(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public int getHeight() {
        return this.height;
    }
}
