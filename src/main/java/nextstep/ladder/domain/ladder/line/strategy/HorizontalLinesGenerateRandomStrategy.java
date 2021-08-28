package nextstep.ladder.domain.ladder.line.strategy;

import nextstep.ladder.domain.ladder.line.HorizontalLine;
import nextstep.ladder.domain.ladder.line.HorizontalLines;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HorizontalLinesGenerateRandomStrategy implements HorizontalLinesGenerateStrategy {

    private static final Random RANDOM = new Random();

    private final int count;
    private final int exclusiveUpperBound;

    public HorizontalLinesGenerateRandomStrategy(int count, int exclusiveUpperBound) {
        this.count = count;
        this.exclusiveUpperBound = exclusiveUpperBound;
    }

    @Override
    public HorizontalLines generate() {
        List<HorizontalLine> horizontalLines = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int index = RANDOM.nextInt(exclusiveUpperBound);
            HorizontalLine horizontalLine = new HorizontalLine(index);
            if (!horizontalLines.contains(horizontalLine))
                horizontalLines.add(horizontalLine);
        }
        return new HorizontalLines(horizontalLines);
    }
}
