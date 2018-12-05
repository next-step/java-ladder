package dto;

import java.util.ArrayList;
import java.util.List;

public class Line {

    public final static int MINUS = 1;
    private List<Point> points = new ArrayList<>();

    public Line(int countOfperson) {
        points.add(Point.isFirst());
        for(int i =1; i <countOfperson-MINUS ; i++ ){
            points.add(Point.isNext(points.get(i-MINUS)));
        }
        points.add(Point.isLast(points.get(points.size()-MINUS)));
    }

    public List<Point> getPoints() {
        return points;
    }

    public int isSize() {
        return points.size();
    }
}
