package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LadderLines {
    private final List<LadderLine> ladderLines;

    private LadderLines(List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    public static LadderLines generateLines(int countOfPerson, int height, MovementGenerator movementGenerator) {
        return new LadderLines(
                Stream.generate(() -> LadderLine.generateLadderLines(countOfPerson, movementGenerator))
                    .limit(height)
                    .collect(collectingAndThen(toList(), Collections::unmodifiableList))
        );
    }

    public int move(int pointIndex) {
        for (int i = 0; i < this.ladderLines.size(); i++) {
            LadderLine ladderLine = this.ladderLines.get(i);
            pointIndex = ladderLine.move(pointIndex);
        }
        return pointIndex;
    }

    public List<LadderLine> getLadderLines() {
        return this.ladderLines;
    }
}
