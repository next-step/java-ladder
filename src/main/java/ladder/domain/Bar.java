package ladder.domain;

public class Bar {

    private final boolean bar;

    private Bar(boolean bar) {
        this.bar = bar;
    }

    public static Bar from(boolean doesBarExist) {
        return new Bar(doesBarExist);
    }

    public boolean isExist() {
        return bar;
    }
}
