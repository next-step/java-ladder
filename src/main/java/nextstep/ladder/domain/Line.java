package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Boolean> points = new ArrayList<>();

    public Line(int height, RuleStrategy ruleStrategy) {
        boolean beforePoint = false;

        for(int i = 0; i < height; i++) {
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

    public List<Boolean> points() {
        return Collections.unmodifiableList(points);
    }
}
