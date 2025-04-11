package nextstep.ladder.domain;

import java.util.Objects;
import java.util.Random;

public class Bridge {
    private final boolean value;

    public Bridge() {
        this(new Random().nextBoolean());
    }

    public Bridge(boolean value) {
        this.value = value;
    }

    public boolean isConnected() {
        return value;
    }

    public Bridge nextBridge() {
        if (this.value)
            return new Bridge(false);

        return new Bridge();
    }

    @Override
    public String toString() {
        return value ? "-----" : "     ";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Bridge bridge = (Bridge) o;
        return value == bridge.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
