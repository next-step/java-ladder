package nextstep.ladder.domain;

import java.util.Objects;

public class Point {

    private static final int POINT_START_INDEX = 0;
    private static final String CANNOT_NULL_DIRECTION = "point의 direction객체는 null일 수 없습니다.";

    private final int index;
    private final Direction direction;
    private static final int DIFFERENCE_BETWEEN_POINT_INDEX = 1;

    public Point(int index, Direction direction) {
        validate(index, direction);
        this.index = index;
        this.direction = direction;
    }

    private void validate(int index, Direction direction) {
        if(index < POINT_START_INDEX){
            throw new IllegalArgumentException("point는"+POINT_START_INDEX+" 이상의 index만 가질 수 있습니다.");
        }
        if(direction == null){
            throw new IllegalArgumentException(CANNOT_NULL_DIRECTION);
        }
    }

    public int move(){
        if(direction.isLeft()){
            return index-DIFFERENCE_BETWEEN_POINT_INDEX;
        }
        if(direction.isRight()){
            return index+DIFFERENCE_BETWEEN_POINT_INDEX;
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
        return new Point( index+DIFFERENCE_BETWEEN_POINT_INDEX, direction.last());
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
