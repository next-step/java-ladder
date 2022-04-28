package ladder.model;

public class Height {

    private final int value;

    public Height(int value) {
        this.value = value;
    }

    public static Height create(int value) {
        return new Height(value);
    }

    public int getValue() {
        return value;
    }

}
