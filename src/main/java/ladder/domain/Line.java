package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final int numberOfPlayers;
    private final Points points = new Points();

    public Line(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        generateLine();
    }

    private void generateLine(){
        Point tmpPoint = Point.randomPoint();
        points.add(tmpPoint);
        for(int i = 1; i < numberOfPlayers-1; i++){
            tmpPoint = Point.next(tmpPoint);
            points.add(tmpPoint);
        }
        tmpPoint = Point.last(tmpPoint);
        points.add(tmpPoint);
    }

    public List<Point> points(){
        return points.points();
    }
}
