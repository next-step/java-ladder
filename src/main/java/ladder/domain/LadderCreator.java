package ladder.domain;

import ladder.dto.LadderInfo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderCreator {
    private static final LadderLineCreator ladderLineCreator = new LadderLineCreator();

    public static Ladder create(LadderInfo ladderInfo, DirectionCreator directionCreator) {
        return new Ladder(createLadderLines(ladderInfo, directionCreator), ladderInfo.getPlayerCount());
    }

    private static List<LadderLine> createLadderLines(LadderInfo ladderInfo, DirectionCreator directionCreator) {
        return Stream.iterate(0, i -> i < ladderInfo.getHeight(), i -> i + 1)
                .map(i -> ladderLineCreator.create(ladderInfo.getPlayerCount(), directionCreator))
                .collect(Collectors.toList());
    }
}
