package nextstep.ladder;

import java.util.Objects;

public class Connection {
    private final int point;

    public Connection(int point) {
        this.point = point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Connection that = (Connection) o;
        return point == that.point;
    }

    @Override
    public int hashCode() {
        return Objects.hash(point);
    }
}
