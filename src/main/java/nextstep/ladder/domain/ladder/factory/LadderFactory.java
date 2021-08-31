package nextstep.ladder.domain.ladder.factory;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.line.HorizontalLine;
import nextstep.ladder.domain.ladder.line.strategy.HorizontalLinesGenerateStrategy;

import java.util.List;

public class LadderFactory {

    private LadderFactory() {
    }

    public static Ladder generateWith(int height, HorizontalLinesGenerateStrategy strategy) {
        List<HorizontalLine> horizontalLines = strategy.generate(height);
        return new Ladder(height, horizontalLines);
    }
}
