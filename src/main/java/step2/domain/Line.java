package step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public String toString() {
        return points.stream()
            .map(LadderType::ladder)
            .collect(Collectors.joining());
    }
}