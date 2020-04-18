package ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderCreator {
    private static final LadderLineCreator ladderLineCreator = new LadderLineCreator();

    public static Ladder create(LadderInfo ladderInfo, int height) {
        return new Ladder(createLadderLines(ladderInfo, height), ladderInfo.getPlayerCount());
    }

    private static List<LadderLine> createLadderLines(LadderInfo ladderInfo, int height) {
        return Stream.iterate(0, i -> i < height, i -> i + 1)
                .map(i -> ladderLineCreator.create(ladderInfo.getPlayerCount(), ladderInfo.getDirectionCreator()))
                .collect(Collectors.toList());
    }
}
