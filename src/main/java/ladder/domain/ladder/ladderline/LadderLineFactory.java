package ladder.domain.ladder.ladderline;

import ladder.domain.ladder.HorizontalLineDirection;
import ladder.domain.ladder.LadderHeight;
import ladder.domain.ladder.LadderWidth;
import ladder.domain.ladder.strategy.LadderConnectStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderLineFactory {
    private static final ThreadLocalRandom random = ThreadLocalRandom.current();
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
        List<HorizontalLineDirection> horizontalLineDirectionLine = new ArrayList<>();
        HorizontalLineDirection beforeHorizontalLineDirection = HorizontalLineDirection.NONE;
        for (int i = 0; i <= ladderWidth.lastLadderIndex() - 1; i++) {
            HorizontalLineDirection currentHorizontalLineDirection = randomConnectableLadder(beforeHorizontalLineDirection);
            horizontalLineDirectionLine.add(currentHorizontalLineDirection);
            beforeHorizontalLineDirection = currentHorizontalLineDirection;
        }
        horizontalLineDirectionLine.add(ladderConnectStrategy.lastLadder(horizontalLineDirectionLine.get(ladderWidth.lastLadderIndex() - 1)));
        return new LadderLine(horizontalLineDirectionLine);
    }

    protected HorizontalLineDirection randomConnectableLadder(HorizontalLineDirection beforeHorizontalLineDirection) {
        List<HorizontalLineDirection> connectableHorizontalLineDirections = ladderConnectStrategy.connectableLadders(beforeHorizontalLineDirection);
        return connectableHorizontalLineDirections.get(random.nextInt(connectableHorizontalLineDirections.size()));
    }
}
