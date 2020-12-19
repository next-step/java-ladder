package nextstep.laddergame.domain;


import java.util.Random;

public class Point {
    private Index index;
    private Direction direction;

    public Point(int index) {
        this.index = Index.from(index);
    }

    public Point(int index, int direction) {
        this.index = Index.from(index);
        this.direction = Direction.from(direction);
    }

    public static Point create(int index) {
        return new Point(index);
    }

    public static Point of(int index, int direction) {
        if (direction == 0) {
            Random random = new Random();
            if (random.nextBoolean()) {
                return new Point(index, 1);
            } else {
                return new Point(index, 0);
            }

//            return new Point(index, 1);
        }

        if (direction == 1) {
            return new Point(index, -1);
        }

        if (direction == -1) {
            return new Point(index, 0);
        }
        return new Point(index,0);
    }

    public static Point createFirst() {
        Random random = new Random();
        random.nextBoolean();

        if (random.nextBoolean()) {
            return new Point(0, 1);
        } else {
            return new Point(0, 0);
        }
    }

    public static Point createLastWithBeforePoint(Point point) {
        if (point.getDirection().isRight()) {
            return new Point(point.index.getIndex() + 1, -1);
        }
        return new Point(point.index.getIndex() + 1, 0);
    }

    public static Point createWithBeforePoint(Point point) {
        Random random = new Random();

        if (point.getDirection().isRight()) {
            return new Point(point.index.getIndex() + 1, -1);
        } else if (point.getDirection().isLeft()) {
            return new Point(point.index.getIndex() + 1, 0);
        } else {
            if (random.nextBoolean()) {
                return new Point(point.index.getIndex() + 1, 1);
            } else {
                return new Point(point.index.getIndex() + 1, 0);
            }
        }
    }

    public int getIndex() {
        return index.getIndex();
    }

    public Direction getDirection() {
        return direction;
    }

    public void canRight() {
        this.direction = Direction.from(1);
    }

    public void canLeft() {
        this.direction = Direction.from(-1);
    }

    public void canNotMove(){
        this.direction = Direction.from(0);
    }
}
