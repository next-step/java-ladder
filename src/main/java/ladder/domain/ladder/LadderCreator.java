package ladder.domain.ladder;

import ladder.domain.player.LadderPlayers;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LadderCreator {
    private Ladder ladder;

    private LadderCreator(LadderPlayers ladderPlayers, int ladderHeight) {
        validateHeight(ladderHeight);
        this.ladder = generateLadder(ladderPlayers, ladderHeight);
    }

    public static LadderCreator create(final LadderPlayers ladderPlayers, final int ladderHeight) {
        return new LadderCreator(ladderPlayers, ladderHeight);
    }

    private Ladder generateLadder(LadderPlayers ladderPlayers, int ladderMaxHeight) {
        List<Line> lineList = Stream
                .generate(() -> Line.createLine(ladderPlayers))
                .limit(ladderMaxHeight)
                .collect(collectingAndThen(toList(), Collections::unmodifiableList));
        return Ladder.create(lineList);
    }

    private void validateHeight(int ladderHeight) {
        if (ladderHeight < 1) {
            throw new IllegalArgumentException("높이는 1보다 작을 수 없습니다.");
        }
    }

    public Ladder getLadder() {
        return ladder;
    }
}
