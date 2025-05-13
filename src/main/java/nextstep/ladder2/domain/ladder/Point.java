package nextstep.ladder2.domain.ladder;

import java.util.Objects;

public class Point {
    
    private boolean previous;
    private boolean current;
    
    public Point(boolean previous, boolean current) {
        if(previous && current) {
            throw new IllegalArgumentException("이전과 현재가 모두 true일 수 없습니다.");
        }
        
        this.previous = previous;
        this.current = current;
    }
    
    public static Point first(boolean current) {
        return new Point(false, current);
    }

    public Point last() {
        return new Point(this.current, false);
    }
    public Point next(boolean current) {
        return new Point(this.current, current);
    }
    public boolean canConnect(boolean nextValue) {
        return ! (this.current && nextValue);
    }
    public boolean current() {
        return current;
    }

    public Direction move() {
        if (previous) {
            return Direction.LEFT;
        } else if (current) {
            return Direction.RIGHT;
        }
        return Direction.PASS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return previous == point.previous && current == point.current;
    }

    @Override
    public int hashCode() {
        return Objects.hash(previous, current);
    }

    @Override
    public String toString() {
        return "Point{" + previous + ", " + current + '}';
    }
}