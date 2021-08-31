package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.ladder.line.HorizontalLine;
import nextstep.ladder.domain.ladder.line.HorizontalLines;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final int height;
    private HorizontalLines horizontalLines;

    public Ladder(int height, HorizontalLines horizontalLines) {
        this.height = height;
        this.horizontalLines = horizontalLines;
    }

    public void removeDuplicatedHorizontalLines(Ladder ladder) {
        HorizontalLines horizontalLines = ladder.getHorizontalLines();

        List<HorizontalLine> duplicatedLines =
                IntStream.iterate(0, i -> i + 1)
                        .limit(this.horizontalLines.size())
                        .filter(horizontalLines::exist)
                        .mapToObj(i -> this.horizontalLines.get(i))
                        .collect(Collectors.toList());

        duplicatedLines.forEach(this.horizontalLines::remove);
    }

    public HorizontalLines getHorizontalLines() {
        return horizontalLines;
    }

    public int getHeight() {
        return height;
    }
}
