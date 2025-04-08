package ladder;

public class Height {
    private final int value;

    public Height(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Height must be greater than 0.");
        }
        this.value = value;
    }

    public int value() {
        return value;
    }
}
