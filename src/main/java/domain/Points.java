package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Points {
    private List<Point> points = new ArrayList<>();

    public void initialize(int i) {
        if( i != 0 && points.get(i-1).isPresent()) {
            points.add(new Point(false));
            return;
        }

        points.add(new Point());
    }

    public Stream<Point> stream() {
        return points.stream();
    }
}
