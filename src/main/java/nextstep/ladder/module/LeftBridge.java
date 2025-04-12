package nextstep.ladder.module;

public class LeftBridge {

    private final boolean isBuilt;

    public LeftBridge() {
        this(false);
    }

    public LeftBridge(boolean isBuilt) {
        this.isBuilt = isBuilt;
    }

    public boolean isBuilt() {
        return isBuilt;
    }
}
