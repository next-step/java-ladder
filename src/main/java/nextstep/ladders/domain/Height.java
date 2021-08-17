package nextstep.ladders.domain;

public class Height {

    private final Integer value;

    private Height(Integer value) {
        this.value = value;
    }

    public static Height valueOf(final Integer value) {
        return new Height(value);
    }
}
