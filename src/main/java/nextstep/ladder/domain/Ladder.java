package nextstep.ladder.domain;

import nextstep.ladder.exception.LadderHeightSizeException;
import nextstep.ladder.strategy.RuleStrategy;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines = new ArrayList<>();

    public Ladder(int height, int width, RuleStrategy ruleStrategy) {
        validateLadderHeight(height);
        for (int i = 0; i < height; i++) {
            lines.add(new Line(width, ruleStrategy));
        }
    }

    private void validateLadderHeight(int height) {
        if (height < 1) {
            throw new LadderHeightSizeException();
        }
    }

    public List<Line> height() {
        return lines;
    }
}
