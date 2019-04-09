package ladder.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Point {
    private boolean previous;
    private boolean current;

    public Point(boolean previous, boolean current) {
        this.previous = previous;
        this.current = current;
    }

    public static Point first(boolean current) {
        return new Point(false, current);
    }

    public static Point last(boolean previous) {
        return new Point(previous, false);
    }

    public Point next(boolean current) {
        if(this.current == true && current == true) {
            return new Point(true, false);
        }                                         
        return new Point(this.current, current);
    }

    public boolean isCurrent() {
        return current;
    }
}
