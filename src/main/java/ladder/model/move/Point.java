package ladder.model.move;

import java.util.Objects;

public class Point {
    private final static int ROW = 1;
    private final static int COLUMN = 1;
    private final static int USER_LOCATION_CORRECTION = 2;
    private final static String POINT_DIRECTION_ERROR = "방향을 찾을 수 없습니다.";
    private final static String BRIDGE_POINT_ERROR = "다리의 시작점은 0일 수 없습니다.";

    private int row, column;

    private Point(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public static Point of(int row, int column) {
        return new Point(row, column);
    }

    public static Point userPoint(int row) {
        return new Point(row * USER_LOCATION_CORRECTION, 0);
    }

    public static Point rewardPoint(int row, int column) {
        return new Point(row * USER_LOCATION_CORRECTION, column);
    }

    public static Point bridgePoint(int row, int column) {
        if(row == 0){
            throw new IllegalArgumentException(BRIDGE_POINT_ERROR);
        }

        return new Point(2 * row - 1, column);
    }

    public static Direction direction(Point from, Point to) {
        if (!isMovable(from, to)) {
            throw new IllegalArgumentException(POINT_DIRECTION_ERROR);
        }

        return (from.row > to.row) ? Direction.LEFT : Direction.RIGHT;
    }

    public static boolean isMovable(Point from, Point to) {
        return ROW == Math.abs(from.row - to.row) && from.column == to.column;
    }

    public Point move(Direction direction) {
        return new Point(row + (direction.getStep() * 2), column);
    }

    public Point moveDown() {
        return new Point(row, column + COLUMN);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point) {
            return ((Point) obj).row == this.row && ((Point) obj).column == this.column;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    @Override
    public String toString() {
        return row+", "+column;
    }
}
