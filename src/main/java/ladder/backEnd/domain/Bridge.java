package ladder.backEnd.domain;

import ladder.backEnd.streategy.ConditionalStrategy;
import ladder.backEnd.streategy.ConnectionStrategy;

import java.util.Objects;

public class Bridge {

    private boolean isConnected;

    public Bridge(boolean isConnected) {
        this.isConnected = isConnected;
    }

    public static Bridge create(ConditionalStrategy conditional, ConnectionStrategy connectionStrategy) {
        if (conditional.connectable()) {
            return new Bridge(connectionStrategy.connect());
        }
        return new Bridge(false);
    }

    public boolean isConnected() {
        return isConnected;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bridge bridge = (Bridge) o;
        return isConnected() == bridge.isConnected();
    }

    @Override
    public int hashCode() {
        return Objects.hash(isConnected());
    }

    @Override
    public String toString() {
        return "Bridge{" +
                "isConnected=" + isConnected +
                '}';
    }
}
