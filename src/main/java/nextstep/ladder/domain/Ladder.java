package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private final LadderHeight height;

    private final List<Line> lines;

    private final LadderResult ladderResult;


    public Ladder(int height, int length, LineGenerator lineGenerator, List<String> results) {
        this.height = new LadderHeight(height);
        this.ladderResult = new LadderResult(results, length+1);
        this.lines = Stream.generate(() -> new Line(length, lineGenerator))
                .limit(height)
                .collect(Collectors.toUnmodifiableList());
    }

    public int getHeight() {
        return height.getHeight();
    }

    public List<Line> getLines() {
        return lines.stream().collect(Collectors.toUnmodifiableList());
    }

    public List<String> getLadderResult() {
        return ladderResult.getResults();
    }
}
