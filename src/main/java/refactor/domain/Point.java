package refactor.domain;

import refactor.domain.pointGenerate.PointStrategy;

public class Point {
    private final int index;
    private final DirectionEnum direction;

    private Point(int index, DirectionEnum direction) {
        this.index = index;
        this.direction = direction;
    }

    public int move() {
        if(direction.equals(DirectionEnum.RIGTH)) {
            return index + 1;
        }

        if(direction.equals(DirectionEnum.LEFT)) {
            return index -1;
        }

        return this.index;
    }

    public Point next(PointStrategy pointStrategy) {
        return new Point(index + 1, direction.next(pointStrategy));
    }

    public Point next(Boolean right) {
        return new Point(index + 1, direction.next(right));
    }

    public Point last() {
        return new Point(index + 1, direction.last());
    }

    public static Point first(Boolean right) {
        return new Point(0, DirectionEnum.first(right));
    }

    @Override
    public String toString() {
        return "Point{" +
                "index=" + index +
                ", direction=" + direction +
                '}';
    }

    public DirectionEnum getDirection() {
        return direction;
    }
}