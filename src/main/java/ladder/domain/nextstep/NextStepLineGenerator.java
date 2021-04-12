package ladder.domain.nextstep;

import ladder.domain.engine.Line;
import ladder.domain.engine.LineGenerator;

import java.util.ArrayList;
import java.util.List;

public class NextStepLineGenerator implements LineGenerator {

    private void generateFirstPoint(List<Point> points){
        Point tmpPoint = Point.randomPoint();
        points.add(tmpPoint);
    }

    private void generateIntermediatePoint(List<Point> points, int numberOfPlayers){
        Point tmpPoint = points.get(points.size()-1);
        for(int i = 1; i < numberOfPlayers-1; i++){
            tmpPoint = Point.next(tmpPoint);
            points.add(tmpPoint);
        }
    }

    private void generateLastPoint(List<Point> points){
        Point tmpPoint = points.get(points.size()-1);
        points.add(Point.last(tmpPoint));
    }

    public Line generateLine(int numberOfPlayers){
        List<Point> points = new ArrayList<>();
        generateFirstPoint(points);
        generateIntermediatePoint(points, numberOfPlayers);
        generateLastPoint(points);
        return new NextStepLine(points);
    }
}
