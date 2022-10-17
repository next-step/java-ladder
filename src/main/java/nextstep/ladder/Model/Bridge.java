package nextstep.ladder.Model;

import java.util.Objects;

public class Bridge {

    private final Boolean isConnect;

    public Bridge(boolean isConnect) {
        this.isConnect = isConnect;
    }


    public boolean isConnect() {
        return isConnect;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bridge)) return false;
        Bridge bridge = (Bridge) o;
        return Objects.equals(isConnect, bridge.isConnect);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isConnect);
    }
}
