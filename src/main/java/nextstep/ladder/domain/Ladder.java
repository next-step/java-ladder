package nextstep.ladder.domain;

import nextstep.ladder.domain.util.DrawStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder from(Heights heights, LadderInputs participants, DrawStrategy drawStrategy) {
        List<Line> lines = Stream.generate(() -> Line.draw(participants.countOfInputs(), drawStrategy))
                .limit(heights.getHeights())
                .collect(Collectors.toList());

        return new Ladder(lines);
    }

    public int getLadderHeights() {
        return lines.size();
    }
}
