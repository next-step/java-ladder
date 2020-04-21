package ladder.infra;

import ladder.domain.DirectionCreator;
import ladder.domain.Ladder;
import ladder.domain.LadderCreator;
import ladder.domain.LadderLine;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BasicLadderCreator implements LadderCreator {
    private static final LadderLineCreator ladderLineCreator = new LadderLineCreator();

    @Override
    public Ladder create(int playerCount, int height, DirectionCreator directionCreator) {
        return new Ladder(createLadderLines(playerCount, height, directionCreator));
    }

    private List<LadderLine> createLadderLines(int playerCount, int height, DirectionCreator directionCreator) {
        return IntStream.range(0, height)
                .mapToObj(i -> ladderLineCreator.create(playerCount, directionCreator))
                .collect(Collectors.toList());
    }
}
