package ladder.domain.game;

import java.util.Objects;

/**
 * Created By mand2 on 2020-12-04.
 */
public class Bridge {

    private final boolean connection;

    private Bridge(boolean connection) {
        this.connection = connection;
    }

    public static Bridge of(boolean inputConnection) {
        return new Bridge(inputConnection);
    }

    public boolean hasConnected() {
        return this.connection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bridge bridge = (Bridge) o;
        return connection == bridge.connection;
    }

    @Override
    public int hashCode() {
        return Objects.hash(connection);
    }
}
