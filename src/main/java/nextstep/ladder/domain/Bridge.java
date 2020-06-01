package nextstep.ladder.domain;

public class Bridge {
    private final boolean isCross;

    public Bridge(boolean isCross) {
        this.isCross = isCross;
    }

    public boolean isCross() {
        return this.isCross;
    }
}
