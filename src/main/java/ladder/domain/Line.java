package ladder.domain;

import ladder.strategy.LadderStrategy;
import ladder.strategy.RandomLadderStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Line {

    private final List<Boolean> lines;

    public Line(int width) {
        this(width, new RandomLadderStrategy());
    }

    public Line(int width, LadderStrategy ladderStrategy) {
        isPositive(width);
        this.lines = generateLines(width, ladderStrategy);
    }

    private void isPositive(int width) {
        if (width < 1) {
            throw new IllegalArgumentException("넓이가 유효하지 않습니다");
        }
    }

    private List<Boolean> generateLines(int width, LadderStrategy ladderStrategy) {
        return Stream.iterate(ladderStrategy.firstLine(), ladderStrategy::nextLine)
                .limit(width)
                .collect(Collectors.toList());
    }

    public List<Boolean> fetchLines() {
        return Collections.unmodifiableList(lines);
    }

    public int countOfLine() {
        return lines.size();
    }

    public boolean hasHorizontalLine(int index) {
        return lines.get(index);
    }
}
