package reladder.domain;

import reladder.service.LadderGame;

import java.util.ArrayList;
import java.util.List;

public class LadderLineGenerator implements LineGenerator {

    private static final int BOUNDARY_INDEX = 1;

    @Override
    public LadderLine generate(int sizeOfPerson) {
        List<Point> points = new ArrayList<>();
        Point point = Point.firstNext(LadderGame.randomGenerate());
        points.add(point);

        for (int i = BOUNDARY_INDEX; i < sizeOfPerson - BOUNDARY_INDEX; i++) {
            point = point.next();
            points.add(point);
        }
        points.add(point.lastNext());
        return new LadderLine(points);
    }
}
