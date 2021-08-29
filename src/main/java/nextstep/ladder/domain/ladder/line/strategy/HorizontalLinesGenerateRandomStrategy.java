package nextstep.ladder.domain.ladder.line.strategy;

import nextstep.ladder.domain.ladder.line.HorizontalLine;
import nextstep.ladder.domain.ladder.line.HorizontalLines;

import java.util.*;
import java.util.stream.Collectors;

public class HorizontalLinesGenerateRandomStrategy implements HorizontalLinesGenerateStrategy {

    private static final Random RANDOM = new Random();

    private final int exclusiveUpperBound;

    public HorizontalLinesGenerateRandomStrategy(int exclusiveUpperBound) {
        this.exclusiveUpperBound = exclusiveUpperBound;
    }

    @Override
    public HorizontalLines generate(int size) {
        Set<HorizontalLine> horizontalLines = new HashSet<>();
        while (horizontalLines.size() != size) {
            int index = RANDOM.nextInt(exclusiveUpperBound);
            HorizontalLine horizontalLine = new HorizontalLine(index);
            horizontalLines.add(horizontalLine);
        }

        return new HorizontalLines(new ArrayList<>(horizontalLines));
    }
}
