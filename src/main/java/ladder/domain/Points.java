package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Points {
    private final List<Point> points = new ArrayList<>();

    public void add(Point point){
        points.add(point);
    }

    public int size(){
        return points.size();
    }

    public Point get(int index){
        return points.get(index);
    }

}
