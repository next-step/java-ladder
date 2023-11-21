package nextstep.ladder.domain;

import nextstep.ladder.exception.LineSizeException;
import nextstep.ladder.strategy.RuleStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private static final int MIN_WIDTH = 2;

    private final List<Boolean> points = new ArrayList<>();

    public Line(int width, RuleStrategy ruleStrategy) {
        boolean beforePoint = false;
        validateWidth(width);
        for (int i = 1; i < width; i++) {
            boolean point = beforePointCheck(beforePoint, ruleStrategy);
            this.points.add(point);
            beforePoint = point;
        }
    }

    private void validateWidth(int width) {
        if (width < MIN_WIDTH) {
            throw new LineSizeException();
        }
    }

    private boolean beforePointCheck(boolean beforePoint, RuleStrategy ruleStrategy) {
        if (beforePoint) {
            return false;
        }
        return ruleStrategy.build();
    }

    public List<Boolean> points() {
        return Collections.unmodifiableList(points);
    }
}
