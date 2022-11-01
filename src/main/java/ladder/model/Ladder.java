package ladder.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private List<LadderLine> ladderLine;

    public Ladder(int playerCount, int height) {
        this.ladderLine = IntStream.range(0, height)
                .mapToObj(i -> LadderLine.create(playerCount))
                .collect(Collectors.toList());
    }

    public List<LadderLine> getLadderLine() {
        return ladderLine;
    }
}

