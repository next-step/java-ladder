package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int ladderHeight, int countOfPerson) {
        checkLadderHeight(ladderHeight);

        this.lines = Stream.generate(() -> Line.generateLine(countOfPerson, new RandomLineGenerator()))
                .limit(ladderHeight)
                .collect(Collectors.toList());
    }

    private void checkLadderHeight(int ladderHeight) {
        if (ladderHeight <= 0) {
            throw new IllegalArgumentException("사다리의 높이는 1 이상이어야 합니다.");
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
