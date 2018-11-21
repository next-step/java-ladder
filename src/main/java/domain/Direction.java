package domain;

import utils.LadderPointGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Direction {
    private final boolean left;
    private final boolean right;
    private static final String LEFT = "LEFT";
    private static  final String RIGHT = "RIGHT";
    private static  final String CENTER = "CENTER";

    private static final Map<String, Direction> directions = new HashMap<>();
    static{
        Direction left = new Direction(true, false);
        Direction right = new Direction(false, true);
        Direction center = new Direction(false, false);

        directions.put(LEFT,left);
        directions.put(RIGHT,right);
        directions.put(CENTER,center);
    }
    private Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalStateException();
        } else {
            this.left = left;
            this.right = right;
        }
    }

    public boolean isRight() {
        return this.right;
    }

    public boolean isLeft() {
        return this.left;
    }

    public Direction next(boolean nextRight) {
        return of(this.right, nextRight);
    }

    public Direction next() {
        return this.right ? this.next(Boolean.FALSE) : this.next(LadderPointGenerator.generatePoint());
    }

    public static Direction of(boolean first, boolean second) {
        if(first && !second){
            return directions.get(LEFT);
        }
        if(!first && second){
            return directions.get(RIGHT);
        }
        if(!first && !second){
            return directions.get(CENTER);
        }
        return new Direction(first, second);
    }

    public static Direction first(boolean right) {
        return of(Boolean.FALSE, right);
    }

    public Direction last() {
        return of(this.right, Boolean.FALSE);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Direction pair = (Direction) o;
            return this.left == pair.left && this.right == pair.right;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.left, this.right});
    }

    public String toString() {
        return "Direction{left=" + this.left + ", right=" + this.right + '}';
    }
}
