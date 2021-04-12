package ladder.domain.nextstep;

import ladder.domain.nextstep.Point;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Points {
    private final List<Point> points = new ArrayList<>();

    public void add(Point point){
        points.add(point);
    }

    public List<Point> points(){
        return Collections.unmodifiableList(points);
    }
}
