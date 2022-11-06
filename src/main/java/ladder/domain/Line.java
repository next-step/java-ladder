package ladder.domain;

import ladder.strategy.LineGenerateStrategy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public Line(Boolean... booleans) {
        this(Arrays.asList(booleans));
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public static Line from(int participantCount, LineGenerateStrategy lineGenerateStrategy) {
        return new Line(lineGenerateStrategy.generate(participantCount));
    }

    public boolean isLastPoint(int index) {
        return points.size() - 1 == index;
    }

    public boolean isMoveAhead(int index) {
        return points.get(index + 1);
    }

    public boolean isMoveBackwards(int index) {
        return points.get(index);
    }

}
