package nextstep.ladder.domain;

import nextstep.ladder.strategy.RuleStrategy;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines = new ArrayList<>();

    public Ladder(int height, int width, RuleStrategy ruleStrategy) {
        for (int i = 0; i < height; i++) {
            lines.add(new Line(width, ruleStrategy));
        }
    }

    public List<Line> height() {
        return lines;
    }
}
