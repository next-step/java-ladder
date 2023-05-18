package ladder.domain;

import ladder.strategy.MoveStratege;
import ladder.strategy.RandomMovableStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final MoveStratege moveStrategy;
    private final List<Line> ladderLines;

    public Ladder(int countOfUsers, int ladderHeight) {
        this.moveStrategy = new RandomMovableStrategy();
        this.ladderLines = createLadderLines(countOfUsers, ladderHeight);
    }

    private List<Line> createLadderLines(int countOfUsers, int ladderHeight) {
        List<Line> lines = new ArrayList<>();

        return IntStream.range(0, ladderHeight)
                .mapToObj(i -> Line.generatePoints(countOfUsers, moveStrategy))
                .collect(Collectors.toList());
    }


    public List<Line> getUnmodifiableLadderLines() {
        return Collections.unmodifiableList(ladderLines);
    }
}
