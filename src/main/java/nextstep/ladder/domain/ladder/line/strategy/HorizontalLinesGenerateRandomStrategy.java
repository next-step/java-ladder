package nextstep.ladder.domain.ladder.line.strategy;

import nextstep.ladder.domain.ladder.line.HorizontalLine;
import nextstep.ladder.domain.ladder.line.HorizontalLines;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HorizontalLinesGenerateRandomStrategy implements HorizontalLinesGenerateStrategy {

    private static final Random RANDOM = new Random();

    public HorizontalLinesGenerateRandomStrategy() {}

    @Override
    public HorizontalLines generate(int size) {
        List<HorizontalLine> horizontalLines = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            boolean exist = RANDOM.nextBoolean();
            HorizontalLine horizontalLine = new HorizontalLine(exist);
            horizontalLines.add(horizontalLine);
        }
        return new HorizontalLines(horizontalLines);
    }
}
