package nextstep.ladder;

public class Height {
    private final int value;

    private Height(int value) {
        this.value = value;
    }

    public static Height of(int value) {
        return new Height(value);
    }
}
