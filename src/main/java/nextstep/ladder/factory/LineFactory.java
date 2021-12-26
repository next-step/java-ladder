package nextstep.ladder.factory;

import nextstep.ladder.generator.LineGenerator;
import nextstep.ladder.model.Index;
import nextstep.ladder.model.Line;
import nextstep.ladder.model.Point;
import nextstep.ladder.utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class LineFactory {

    private LineFactory() {
    }

    public static Line of(int countOfPerson, LineGenerator generator) {
        return of(RandomUtils.nextBoolean(), countOfPerson, generator);
    }

    public static Line of(boolean first, int countOfPerson, LineGenerator generator) {
        List<Point> points = new ArrayList<>();
        Point firstPoint = new Point(Index.ZERO, first);
        points.add(firstPoint);
        loopGenerate(points, countOfPerson, generator);
        return new Line(points);
    }

    private static void loopGenerate(List<Point> points, int countOfPerson, LineGenerator generator) {
        for (int i = 1; i < countOfPerson - 1; i++) {
            Point prevPoint = points.get(i - 1);
            points.add(prevPoint.next(generator));
        }
    }
}
