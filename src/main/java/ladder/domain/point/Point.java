package ladder.domain.point;

import java.util.Objects;

public class Point {
    
    private static final Point CONNECT = new Point(true);
    private static final Point DISCONNECT = new Point(false);

    private final boolean connect;

    public Point(boolean connect) {
        this.connect = connect;
    }

    public static Point connect() {
        return CONNECT;
    }

    public static Point disconnect() {
        return DISCONNECT;
    }

    public boolean isConnect() {
        return CONNECT.equals(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return connect == point.connect;
    }

    @Override
    public int hashCode() {
        return Objects.hash(connect);
    }
}
