package dto;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {

    public final static int MINUS = 1;
    private List<Point> points = new ArrayList<>();
    Mode mode;

    public LadderLine(int countOfperson , Mode mode) {
        this.mode = mode;
        initFirst();
        initBody(countOfperson);
        initLast();
    }

    private void initFirst() {
        this.points.add(Point.isFirst(this.mode));
    }
    private void initLast() {
        this.points.add(Point.isLast(this.points.get(points.size()-1)));
    }

    private void initBody(int sizeOfPerson) {
        for (int i = 1; i < sizeOfPerson - MINUS; i++) {
            this.points.add(Point.isNext(this.points.get(i-MINUS),this.mode));
        }
    }

    public List<Point> getPoints() {
        return points;
    }

    public int move(int index){
        return this.points.get(index).move();
    }
}
