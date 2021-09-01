package newladder.model;

import newladder.util.RandomBoolean;

import java.util.Random;

public class Direction {
    private Point point;

    public Direction() {
        this.point = Point.first(RandomBoolean.Random());
    }

    public Direction(Point point) {
        this.point = point;
    }

    public int move() {
        if (point.isLeft()) {
            return - 1;
        }
        if (point.isRight()) {
            return 1;
        }
        return 0;
     }

     public Direction next() {
        return new Direction(this.point.nextPoint(RandomBoolean.Random()));
     }

    public Direction last() {
        return new Direction(this.point.last());
    }

    public Direction first() {
        return new Direction(Point.first(RandomBoolean.Random()));
    }


}
