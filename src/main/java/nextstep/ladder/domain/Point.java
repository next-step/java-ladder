package nextstep.ladder.domain;

import java.util.Objects;

public class Point {

    private static final int POINT_START_INDEX = 0;

    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public int move(){
        if(direction.isLeft()){
            return index-1;
        }
        if(direction.isRight()){
            return index+1;
        }
        return index;
    }

    public Point next(boolean right){
        return new Point(index+1, direction.next(right));
    }

    public static Point first(boolean right){
        return new Point(POINT_START_INDEX, Direction.first(right));
    }

    public Point last(){
        return new Point( index+1, direction.last());
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return "Point{" +
                "index=" + index +
                ", direction=" + direction +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return (point.index == this.index) && (point.direction.equals(this.direction));

    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }

}
