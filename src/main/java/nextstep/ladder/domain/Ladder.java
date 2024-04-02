package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private final List<Line> lines;


    public Ladder(int height, int length, LineGenerator lineGenerator) {
        LadderHeight ladderHeight = new LadderHeight(height);
        this.lines = Stream.generate(() -> new Line(length, lineGenerator))
                .limit(ladderHeight.getHeight())
                .collect(Collectors.toUnmodifiableList());
    }

    public int getHeight() {
        return lines.size();
    }

    public List<Line> getLines() {
        return lines.stream().collect(Collectors.toUnmodifiableList());
    }
}
