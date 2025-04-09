package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Line {
    private final List<Boolean> points;

    public Line(int countOfPerson) {
        // 라인의 좌표 값에 선이 있는지 유무를 판단하는 로직 추가
        this(createPoints(countOfPerson, () -> new Random().nextBoolean()));
    }

    public Line(List<Boolean> points) {
        this.points = points;
    }

    private static List<Boolean> createPoints(int countOfPerson, GeneratorStrategy strategy) {
        List<Boolean> points = new ArrayList<>();
        boolean previousHasLine = false;

        for (int i = 0; i < countOfPerson; i++) {
            boolean hasLine = !previousHasLine && strategy.isGenerate();
            points.add(hasLine);
            previousHasLine = hasLine;
        }

        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(points);
    }
}

