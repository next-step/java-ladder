package nextstep.laddergame.model;

import java.util.Objects;

public class Bridge {

    private static final int FALSE = 0;

    private final boolean exist;

    public Bridge(int booleanNumber) {
        this(convertToBoolean(booleanNumber));
    }

    private static boolean convertToBoolean(int booleanNumber) {
        return booleanNumber != FALSE;
    }

    public Bridge(boolean exist) {
        this.exist = exist;
    }

    public static Bridge empty() {
        return new Bridge(false);
    }

    public boolean exist() {
        return exist;
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
        return exist == bridge.exist;
    }

    @Override
    public int hashCode() {
        return Objects.hash(exist);
    }
}
