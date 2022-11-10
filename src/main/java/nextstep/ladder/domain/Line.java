package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> points = new ArrayList<>();

    private Line(LineGenerationStrategy lineGenerationStrategy, int countOfPerson) {
        for (int i = 0; i < countOfPerson - 1; i++) {
            points.add(lineGenerationStrategy.generate());
        }
    }

    public static Line of(LineGenerationStrategy lineGenerationStrategy, int countOfPerson) {
        return new Line(lineGenerationStrategy, countOfPerson);
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
