package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Point> line = new ArrayList<>();

    private Line(int size) {
        Point prevPoint = new Point();
        for(int i = 1 ; i < size; i ++){
            Point point = prevPoint.next();
            line.add(point);

            prevPoint = point;
        }
    }

    public static Line of(int size){
        return new Line(size);
    }

    public List<Point> getLine(){
        return new ArrayList<>(line);
    }
}
