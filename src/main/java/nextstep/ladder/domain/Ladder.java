package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private final List<Lines> lines;

    public Ladder(List<Lines> lines) {
        this.lines = lines;
    }

    public static Ladder from(Heights heights, LadderInputs participants, DrawStrategy drawStrategy) {
        List<Lines> lines = Stream.generate(() -> Lines.drawLines(participants, drawStrategy))
                .limit(heights.getHeights())
                .collect(Collectors.toList());

        return new Ladder(lines);
    }

    public Results getResults(Results previousResults) {
        Results results = previousResults;
        for (Lines line : lines) {
            results = line.followLine(previousResults);
            previousResults = results;
        }

        return results;
    }

    public int getLadderHeights() {
        return lines.size();
    }

    public List<Lines> getLadder() {
        return lines;
    }
}
