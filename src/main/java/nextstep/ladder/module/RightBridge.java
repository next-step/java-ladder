package nextstep.ladder.module;

public class RightBridge {

    private final boolean isBuilt;

    public RightBridge() {
        this(false);
    }

    public RightBridge(boolean isBuilt) {
        this.isBuilt = isBuilt;
    }

    public boolean isBuilt() {
        return isBuilt;
    }
}
