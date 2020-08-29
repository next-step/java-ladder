package ladder.domain;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Ladder {
    private List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(int ladderHeight, Participants participant, LineGenerator lineGenerator) {
        return Stream.generate(() -> Line.create(participant, lineGenerator))
                .limit(ladderHeight)
                .collect(collectingAndThen(toList(), Ladder::new));
    }

    public List<Line> getLines() {
        return lines;
    }

    public int getFinalIndex(Participant participant) {
        int index = participant.getStartIndex();

        for (Line line : lines) {
            index = line.calculateNextIndex(index);
        }

        return index;
    }
}
