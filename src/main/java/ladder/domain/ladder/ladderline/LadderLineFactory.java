package ladder.domain.ladder.ladderline;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderHeight;
import ladder.domain.ladder.LadderWidth;
import ladder.domain.ladder.strategy.LadderConnectStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderLineFactory {

    private final LadderConnectStrategy ladderConnectStrategy;

    public LadderLineFactory(LadderConnectStrategy ladderConnectStrategy) {
        this.ladderConnectStrategy = ladderConnectStrategy;
    }

    public LadderLines randomLadderLines(LadderWidth ladderWidth, LadderHeight ladderHeight) {
        return new LadderLines(IntStream.range(0, ladderHeight.height())
                .mapToObj(i -> randomLadderLine(ladderWidth))
                .collect(Collectors.toList()));
    }

    public LadderLine randomLadderLine(LadderWidth ladderWidth) {
        List<Ladder> ladderLine = new ArrayList<>();
        Ladder beforeLadder = Ladder.NONE;
        for (int i = 0; i <= ladderWidth.lastLadderIndex() - 1; i++) {
            Ladder currentLadder = randomConnectableLadder(beforeLadder);
            ladderLine.add(currentLadder);
            beforeLadder = currentLadder;
        }
        ladderLine.add(ladderConnectStrategy.lastLadder(ladderLine.get(ladderWidth.lastLadderIndex() - 1)));
        return new LadderLine(ladderLine);
    }

    protected Ladder randomConnectableLadder(Ladder beforeLadder) {
        List<Ladder> connectableLadders = ladderConnectStrategy.connectableLadders(beforeLadder);
        return connectableLadders.get(new Random().nextInt(connectableLadders.size()));
    }
}
