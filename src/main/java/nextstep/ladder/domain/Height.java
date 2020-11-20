package nextstep.ladder.domain;

public class Height {
    public final int value;

    private Height(int value) {
        this.value = value;
    }

    public static Height valueOf(int value) {
        return new Height(value);
    }
}
