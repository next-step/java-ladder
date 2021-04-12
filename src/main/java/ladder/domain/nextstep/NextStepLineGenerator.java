package ladder.domain.nextstep;

import ladder.domain.engine.Line;
import ladder.domain.engine.LineGenerator;

import java.util.ArrayList;
import java.util.List;

public class NextStepLineGenerator implements LineGenerator {
    private void generateFirstPoint(List<NextStepPoint> points){
        NextStepPoint tmpPoint = NextStepPoint.randomPoint();
        points.add(tmpPoint);
    }

    private void generateIntermediatePoint(List<NextStepPoint> points, int numberOfPlayers){
        NextStepPoint tmpPoint = points.get(points.size()-1);
        for(int i = 1; i < numberOfPlayers-1; i++){
            tmpPoint = NextStepPoint.next(tmpPoint);
            points.add(tmpPoint);
        }
    }

    private void generateLastPoint(List<NextStepPoint> points){
        NextStepPoint tmpPoint = points.get(points.size()-1);
        points.add(NextStepPoint.last(tmpPoint));
    }

    public Line generateLine(int numberOfPlayers){
        List<NextStepPoint> points = new ArrayList<>();
        generateFirstPoint(points);
        generateIntermediatePoint(points, numberOfPlayers);
        generateLastPoint(points);
        return new NextStepLine(points);
    }
}
