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

    public int getLineSize() {
        return points.size();
    }

    public boolean getPoint(int index) {
        return points.get(index);
    }

    public boolean isLastPoint(int index) {
        return points.size() - 1 == index;
    }

}
