package ladder.domain;

import ladder.strategy.LadderStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    public static final int MINIMUM_HEIGHT_OF_LADDER = 1;

    private final List<Line> lines;
    private final int width;
    private final int height;

    public Ladder(int width, int height, LadderStrategy ladderStrategy) {
        isPositive(height);
        this.lines = generateLines(width, height, ladderStrategy);
        this.width = width;
        this.height = height;
    }

    private void isPositive(int height) {
        if (height < MINIMUM_HEIGHT_OF_LADDER) {
            throw new IllegalArgumentException("사다리 높이는 양수여야 합니다");
        }
    }

    private List<Line> generateLines(int width, int height, LadderStrategy ladderStrategy) {
        return IntStream.range(0, height)
                .mapToObj(i -> new Line(width, ladderStrategy))
                .collect(Collectors.toList());
    }

    public List<Line> fetchLines() {
        return Collections.unmodifiableList(lines);
    }

    public void validateWidth(int participants) {
        if (width != participants) {
            throw new IllegalArgumentException("사다리의 너비와 참가자 수가 일치하지 않습니다");
        }
    }
}

