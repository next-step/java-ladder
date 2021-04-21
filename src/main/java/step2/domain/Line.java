package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final LineStrategy lineStrategy;
    private final List<LadderType> points = new ArrayList<>();

    public Line(int countOfPerson, LineStrategy lineStrategy) {
        this.lineStrategy = lineStrategy;
        createLine(countOfPerson);
    }

    public List<LadderType> points() {
        return this.points;
    }

    private void createLine(int countOfPerson) {
        points.add(lineStrategy.next());
        for (int prevPoint = 0; prevPoint < countOfPerson - 2; ++prevPoint) {
            LadderType prevType = points.get(prevPoint);
            points.add(lineStrategy.next(prevType));
        }
        LadderType prevLast = points.get(countOfPerson - 2);
        points.add(lineStrategy.last(prevLast));
    }
}