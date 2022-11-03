package ladder.domain;

import ladder.strategy.LineGenerateStrategy;

import java.util.List;

public class Line {
    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public Line(int participantCount, LineGenerateStrategy lineGenerateStrategy) {
        this(lineGenerateStrategy.generateLine(participantCount));
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public static Line from(int participantCount, LineGenerateStrategy lineGenerateStrategy) {
        return new Line(lineGenerateStrategy.generateLine(participantCount));
    }

}
