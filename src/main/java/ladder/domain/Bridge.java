package ladder.domain;

import java.util.Objects;

public class Bridge {
    private final boolean bridge;

    public Bridge(boolean isConnected) {
        this.bridge = isConnected;
    }

    public boolean isConnected() {
        return bridge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bridge)) return false;
        Bridge bridge1 = (Bridge) o;
        return bridge == bridge1.bridge;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bridge);
    }
}
