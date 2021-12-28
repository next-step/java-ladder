package ladderinterface.concrete;

import ladderinterface.engine.Line;
import ladderinterface.engine.LineCreator;
import ladderinterface.util.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;


public class LadderLineCreator implements LineCreator {
    private final BooleanGenerator generator;

    public LadderLineCreator(BooleanGenerator generator) {
        this.generator = generator;
    }

    @Override
    public Line create(int countOfPlayers) {
        List<Point> points = new ArrayList<>();
        Point point = Point.first(generator);
        points.add(point);

        for (int i = 1; i < countOfPlayers - 1; i++) {
            point = point.next();
            points.add(point);
        }
        points.add(point.last());
        return LadderLine.of(points);
    }
}
