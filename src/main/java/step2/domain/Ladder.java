package step2.domain;

import step2.exception.LadderHeightException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Collections.unmodifiableList;

public class Ladder {
    private final List<Line> ladder;

    private Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    public static Ladder of(final Players players, final int ladderHeight, final LineStrategy lineStrategy) {
        validLineHeight(ladderHeight);

        return new Ladder(IntStream.range(0, ladderHeight)
                .mapToObj(i -> Line.of(players.getPlayersCount(), lineStrategy))
                .collect(Collectors.toList()));
    }

    private static void validLineHeight(int ladderHeight) {
        if (ladderHeight < 1) {
            throw new LadderHeightException();
        }
    }

    public List<Line> getLadder() {
        return unmodifiableList(ladder);
    }
}
