package nextstep.ladder.domain;

import nextstep.ladder.domain.strategy.GenerateLadderPoint;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Boolean> points;

    public Line(int namesSize, GenerateLadderPoint generateLadderPoint) {
        this.points = generateLadderPoint.generate(namesSize);
        if (this.points == null) {
            this.points = new ArrayList<>();
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
