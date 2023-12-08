package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private static final int MIN_HEIGHT_OF_LADDER = 1;

    private final List<String> playerNames;

    private final List<Line> lines;

    public Ladder(List<String> playerNames, List<Line> lines) {
        this.playerNames = playerNames;
        this.lines = lines;
    }

    public static Ladder of(List<String> playerNames, int maxHeightOfLadder) {
        if (maxHeightOfLadder < MIN_HEIGHT_OF_LADDER) {
            throw new IllegalArgumentException("최소 높이는 최소 " + MIN_HEIGHT_OF_LADDER +"이상이어야 합니다.");
        }

        List<Line> lines = IntStream.range(0, maxHeightOfLadder)
                .mapToObj(idx -> Line.of(playerNames.size()))
                .collect(Collectors.toList());

        return new Ladder(playerNames, lines);
    }

    public List<Line> lines() {
        return new ArrayList<>(lines);
    }
}
