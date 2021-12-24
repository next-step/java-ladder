package ladderinterface.concrete;

import ladderinterface.engine.Line;
import ladderinterface.engine.LineCreator;
import ladderinterface.util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;


public class LadderLineCreator implements LineCreator {

    @Override
    public Line create(int countOfPlayers) {
        List<Point> points = new ArrayList<>();
        Point point = Point.first(RandomGenerator.generate());
        points.add(point);

        for (int i = 1; i < countOfPlayers - 1; i++) {
            point = point.nextRandom();
            points.add(point);
        }
        points.add(point.last());
        return LadderLine.of(points);
    }
}
