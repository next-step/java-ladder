package nextstep.ladder.domain;

import nextstep.ladder.exception.LineSizeException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Boolean> points = new ArrayList<>();

    public Line(int width, RuleStrategy ruleStrategy) {
        boolean beforePoint = false;
        checkWidth(width);
        for(int i = 0; i < width; i++) {
            boolean point = beforePointCheck(beforePoint, ruleStrategy);
            this.points.add(point);
            beforePoint = point;
        }
    }

    private boolean beforePointCheck(boolean beforePoint, RuleStrategy ruleStrategy) {
        if(beforePoint) {
            return false;
        }
        return ruleStrategy.build();
    }

    private void checkWidth(int width) {
        if(width < 2) {
            throw new LineSizeException();
        }
    }

    public List<Boolean> points() {
        return Collections.unmodifiableList(points);
    }
}
