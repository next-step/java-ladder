package nextstep.ladder.domain;

public class Bridge {
    private final boolean value;

    public Bridge(boolean value) {
        this.value = value;
    }

    public boolean canCrossBridge() {
        return value;
    }
}
