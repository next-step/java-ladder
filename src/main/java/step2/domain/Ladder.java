package step2.domain;

import step2.exception.LadderHeightException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Collections.unmodifiableList;

public class Ladder {
    public static final int MIN_LADDER_HEIGHT = 1;
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(final Players players, final int ladderHeight, final LineStrategy lineStrategy) {
        validLineHeight(ladderHeight);

        return new Ladder(IntStream.range(0, ladderHeight)
                .mapToObj(i -> Line.of(players.getPlayersCount(), lineStrategy))
                .collect(Collectors.toList()));
    }

    private static void validLineHeight(int ladderHeight) {
        if (ladderHeight < MIN_LADDER_HEIGHT) {
            throw new LadderHeightException();
        }
    }

    public List<Line> getLines() {
        return unmodifiableList(lines);
    }
}
