package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> points = new ArrayList<>();
    private final LineGenerationStrategy lineGenerationStrategy;

    private Line(LineGenerationStrategy lineGenerationStrategy, int countOfPerson) {
        this.lineGenerationStrategy = lineGenerationStrategy;
        for (int i = 0; i < countOfPerson - 1; i++) {
            points.add(generatePoint(i));
        }
    }

    public static Line of(LineGenerationStrategy lineGenerationStrategy, int countOfPerson) {
        return new Line(lineGenerationStrategy, countOfPerson);
    }

    private Boolean generatePoint(int i) {
        if (generatable(i)) {
            return lineGenerationStrategy.generate();
        }
        return false;
    }

    private boolean generatable(int index) {
        if (index == 0) {
            return true;
        }
        return !points.get(index - 1);
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
