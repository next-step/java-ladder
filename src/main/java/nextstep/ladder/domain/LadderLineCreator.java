package nextstep.ladder.domain;

import static nextstep.ladder.util.RandomGenerator.generate;

import java.util.ArrayList;
import java.util.List;

public class LadderLineCreator {

    public LadderLine create(int countOfPerson) {
        List<ImprovingPoint> points = new ArrayList<>();
        ImprovingPoint point = initFirst(points);
        point = initBody(countOfPerson, points, point);
        initLast(points, point);
        return new LadderLine(points);
    }

    private ImprovingPoint initBody(int countOfPerson, List<ImprovingPoint> points,
                                    ImprovingPoint point) {
        for (int i = 1; i < countOfPerson - 1; i++) {
            point = point.next();
            points.add(point);
        }
        return point;
    }

    private void initLast(List<ImprovingPoint> points, ImprovingPoint point) {
        point = point.last();
        points.add(point);
    }

    private ImprovingPoint initFirst(List<ImprovingPoint> points) {
        ImprovingPoint point = ImprovingPoint.first(generate());
        points.add(point);
        return point;
    }
}
