package ladder.structure.connection.result;

import ladder.structure.connection.Connection;

import java.util.List;
import java.util.Objects;

import static ladder.structure.connection.Connection.NOT_CONNECTED_BRIDGE;

public class Point {
    public static final int MOVE_RIGHT = 1;
    private static final int MOVE_STRAIGHT = 0;
    private static final int MOVE_LEFT = -1;
    private static final int CONNECTION_TO_RIGHT = 0;
    private static final int CONNECTION_TO_LEFT = -1;
    private final int point;
    private int direction;

    private Point(int num) {
        this.point = num;
    }

    private Point(int num, int direction) {
        this.point = num;
        this.direction = direction;
    }

    public static Point of(int num) {
        Point point = new Point(num);
        return point;
    }

    public static Point of(int num, int direction) {
        Point point = new Point(num, direction);
        return point;
    }

    private boolean isPossibleToGoLeft(List<Connection> connections) {
        return isConnectedConnection(connections, point + CONNECTION_TO_LEFT);
    }

    private boolean isPossibleToGoRight(List<Connection> connections) {
        return isConnectedConnection(connections, point + CONNECTION_TO_RIGHT);
    }

    public int getDirection() {
        return direction;
    }

    private boolean isConnectedConnection(List<Connection> connections, int index) {
        if (index < 0 || index >= connections.size()) {
            return NOT_CONNECTED_BRIDGE.isConnected();
        }
        return connections.get(index).isConnected();
    }

    public Point move(List<Connection> connections) {
        if (isPossibleToGoLeft(connections)) {
            this.direction = MOVE_LEFT;
            return Point.of(this.point + MOVE_LEFT);
        }
        if (isPossibleToGoRight(connections)) {
            this.direction = MOVE_RIGHT;
            return Point.of(this.point + MOVE_RIGHT);
        }
        this.direction = MOVE_STRAIGHT;
        return Point.of(this.point + MOVE_STRAIGHT);
    }

    @Override
    public String toString() {
        return "Point{" + "point=" + point + '}';
    }

    public int value() {
        return point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point1 = (Point) o;
        return point == point1.point;
    }

    @Override
    public int hashCode() {
        return Objects.hash(point);
    }
}
