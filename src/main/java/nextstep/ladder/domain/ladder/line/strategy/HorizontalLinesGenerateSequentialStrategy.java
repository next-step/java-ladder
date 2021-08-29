package nextstep.ladder.domain.ladder.line.strategy;

import nextstep.ladder.domain.ladder.line.HorizontalLine;
import nextstep.ladder.domain.ladder.line.HorizontalLines;

import java.util.ArrayList;
import java.util.List;

public class HorizontalLinesGenerateSequentialStrategy implements HorizontalLinesGenerateStrategy {


    public HorizontalLinesGenerateSequentialStrategy() {}

    @Override
    public HorizontalLines generate(int size) {
        List<HorizontalLine> horizontalLines = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            HorizontalLine horizontalLine = new HorizontalLine(i);
            horizontalLines.add(horizontalLine);
        }

        return new HorizontalLines(horizontalLines);
    }
}
