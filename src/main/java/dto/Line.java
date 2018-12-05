package dto;

import java.util.ArrayList;

public class Line {

    public final static int MINUS = 1;
    private ArrayList<Point> points2 = new ArrayList<>();

    public Line(int countOfperson) {
        points2.add(Point.isFirst());
        for(int i =1; i <countOfperson-MINUS ; i++ ){
            points2.add(Point.isNext(points2.get(i-MINUS)));
        }
        points2.add(Point.isLast(points2.get(points2.size()-MINUS)));
    }

    public ArrayList<Point> getPoints2() {
        return points2;
    }

    public int isSize() {
        return points2.size();
    }

}
