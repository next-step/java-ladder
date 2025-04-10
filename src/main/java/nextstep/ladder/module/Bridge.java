package nextstep.ladder.module;

public class Bridge {

    private final boolean isBuilt;

    public Bridge() {
        this(false);
    }

    public Bridge(boolean isBuilt) {
        this.isBuilt = isBuilt;
    }

    public boolean isBuilt() {
        return isBuilt;
    }
}
