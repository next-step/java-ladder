package ladder.infra;

import ladder.domain.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BasicLadderCreator implements LadderCreator {
    private static final LadderLineCreator ladderLineCreator = new LadderLineCreator();

    @Override
    public Ladder create(LadderInfo ladderInfo, DirectionCreator directionCreator) {
        return new Ladder(createLadderLines(ladderInfo, directionCreator));
    }

    private List<LadderLine> createLadderLines(LadderInfo ladderInfo, DirectionCreator directionCreator) {
        int height = ladderInfo.getHeight();
        return IntStream.range(0, height)
                .mapToObj(i -> ladderLineCreator.create(ladderInfo.getPlayerCount(), directionCreator))
                .collect(Collectors.toList());
    }
}
