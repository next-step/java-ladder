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

    public int move(int position) {
        if (isMoveRight(position)) {
            return position + 1;
        }
        if (isMoveLeft(position)) {
            return position - 1;
        }
        return position;
    }

    public List<Boolean> getPoints() {
        return points;
    }

    private boolean isMoveRight(int position) {
        return position < points.size() && points.get(position);
    }

    private boolean isMoveLeft(int position) {
        return position > 0 && points.get(position - 1);
    }
}
