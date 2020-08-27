package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(int ladderHeight, Participants participant, LineGenerator lineGenerator) {
        List<Line> lines = Stream.iterate(0, line -> line + 1)
                .limit(ladderHeight)
                .map(line -> Line.create(participant, lineGenerator))
                .collect(Collectors.toList());

        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return lines;
    }

}
