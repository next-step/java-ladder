package ladder_v2.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    public static final int MINIMUM_POINTS_COUNT = 2;
    private final List<Point> points = new ArrayList<>();

    public static Line of(int count){
        if(count < MINIMUM_POINTS_COUNT){
            throw new IllegalArgumentException("Line은 최소 2개의 Point를 가져야 합니다.");
        }
        return new Line().make(count);
    }

    public Line make(int count){
        Point point = Point.first();
        points.add(point);
        for(int i = 1; i < count - 1; i++){
            point = point.middle();
            points.add(point);
        }
        points.add(point.last());
        return this;
    }

    public List<Point> points() {
        return points;
    }

    public Direction move(int i) {
        return points.get(i).move();
    }
}
