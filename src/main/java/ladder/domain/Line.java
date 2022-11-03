package ladder.domain;

import ladder.strategy.LineGenerateStrategy;

import java.util.List;

public class Line {
    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public Line(int participantCount, LineGenerateStrategy lineGenerateStrategy) {
        this(lineGenerateStrategy.generate(participantCount));
    }

    public List<Boolean> getPoints() {
        return points;
    }

}
