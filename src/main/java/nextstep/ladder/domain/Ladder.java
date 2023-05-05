package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Lines> lines;

    public Ladder(List<Lines> lines) {
        this.lines = lines;
    }

    public static Ladder from(Heights heights, Participants participants, DrawStrategy drawStrategy) {
        List<Lines> lines = IntStream.range(0, heights.getHeights())
                .mapToObj(i -> Lines.drawLines(participants, drawStrategy))
                .collect(Collectors.toList());

        return new Ladder(lines);
    }

    public int getLadderHeights() {
        return lines.size();
    }

    public List<Lines> getLadder() {
        return lines;
    }
}
