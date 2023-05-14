package nextstep.ladder.domain;

import nextstep.ladder.domain.util.DrawStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private static final int FIRST_INDEX = 0;
    private static final int SECOND_INDEX = 1;

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

    public Results move() {
        Results results = Results.firstMove(lines.get(FIRST_INDEX));

        for (int i = SECOND_INDEX; i < lines.size(); i++) {
            results = results.nextMove(lines.get(i));
        }

        return results;
    }

    public int getLadderHeights() {
        return lines.size();
    }

    public List<Line> getLines() {
        return lines;
    }
}
