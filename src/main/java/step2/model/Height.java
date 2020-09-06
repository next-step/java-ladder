package step2.model;

public class Height {
    private final int height;

    private Height(int value) {
        this.height = value;
    }

    public static Height valueOf(int value) {
        validateParameter(value);
        return new Height(value);
    }

    private static void validateParameter(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public int getHeight() {
        return this.height;
    }
}
