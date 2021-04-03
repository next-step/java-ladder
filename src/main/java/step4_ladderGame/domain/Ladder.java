package step4_ladderGame.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Ladder {

    private final List<LadderLine> ladderLines;

    public Ladder(List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    public static Ladder initLadder(int height, int playerCount, CreatePointStrategy createPointStrategy) {
        return Stream.generate(() -> LadderLine.initLadderLine(playerCount, createPointStrategy))
                .limit(height)
                .collect(Collectors.collectingAndThen(toList(), Ladder::new));
    }

    public int size() {
        return ladderLines.size();
    }
}
