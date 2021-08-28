package nextstep.ladder.domain.ladder.factory;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.line.HorizontalLines;
import nextstep.ladder.domain.ladder.line.strategy.HorizontalLinesGenerateStrategy;

public class LadderFactory {

    public static Ladder generateWith(int height, HorizontalLinesGenerateStrategy strategy) {
        HorizontalLines horizontalLines = strategy.generate();
        return new Ladder(height, horizontalLines);
    }
}
