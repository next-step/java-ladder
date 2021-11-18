package nextstep.step2.vo;

import java.util.Objects;

public class Bridge {
    public static final Bridge FALSE = new Bridge(false);
    public static final Bridge TRUE = new Bridge(true);

    private final boolean value;

    private Bridge(Boolean value) {
        this.value = value;
    }

    public static Bridge create(Boolean value) {
        return getCachedBridge(value);
    }

    private static Bridge getCachedBridge(Boolean value) {
        if (value) {
            return TRUE;
        }

        return FALSE;
    }

    public boolean getValue() {
        return value;
    }

    public boolean isGo() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Bridge bridge = (Bridge) o;
        return Objects.equals(value, bridge.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Point{" +
                "value=" + value +
                '}';
    }
}
