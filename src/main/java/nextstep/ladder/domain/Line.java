package nextstep.ladder.domain;

import nextstep.ladder.domain.strategy.GenerateLadderPoint;

import java.util.List;

public class Line {
    private List<Boolean> points;

    public Line(int namesSize, GenerateLadderPoint generateLadderPoint) {
        this.points = generateLadderPoint.generate(namesSize);
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
