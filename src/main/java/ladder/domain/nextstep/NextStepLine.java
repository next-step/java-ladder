package ladder.domain.nextstep;

import java.util.List;

public class NextStepLine {
    private final int numberOfPlayers;
    private final Points points = new Points();

    public NextStepLine(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        generateLine();
    }

    private Point generateFirstPoint(){
        Point tmpPoint = Point.randomPoint();
        points.add(tmpPoint);
        return tmpPoint;
    }

    private Point generateIntermediatePoint(Point tmpPoint){
        for(int i = 1; i < numberOfPlayers-1; i++){
            tmpPoint = Point.next(tmpPoint);
            points.add(tmpPoint);
        }
        return tmpPoint;
    }

    private void generateLastPoint(Point tmpPoint){
        points.add(Point.last(tmpPoint));
    }

    private void generateLine(){
        Point tmpPoint = generateFirstPoint();
        tmpPoint = generateIntermediatePoint(tmpPoint);
        generateLastPoint(tmpPoint);
    }

    public List<Point> points(){
        return points.points();
    }
}
