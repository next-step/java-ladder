package nextstep.ladder.domain.ladder.line.strategy;

import nextstep.ladder.domain.ladder.line.HorizontalLine;
import nextstep.ladder.domain.ladder.line.HorizontalLines;

import java.util.ArrayList;
import java.util.List;

public class HorizontalLinesGenerateSequentialStrategy implements HorizontalLinesGenerateStrategy {

    private final int count;

    public HorizontalLinesGenerateSequentialStrategy(int count) {
        this.count = count;
    }

    @Override
    public HorizontalLines generate() {
        List<HorizontalLine> horizontalLines = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            HorizontalLine horizontalLine = new HorizontalLine(i);
            horizontalLines.add(horizontalLine);
        }

        return new HorizontalLines(horizontalLines);
    }
}
