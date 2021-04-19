package ladder.domain;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    private final Map<Player, Reward> gameResult;

    public LadderGame(Map<Player, Reward> gameResult) {
        this.gameResult = gameResult;
    }

    public static LadderGame valueOf(LadderEdge ladderEdge, Ladder ladder) {
        Map<Player, Reward> result = IntStream.range(0, ladderEdge.playerSize())
                .boxed()
                .collect(Collectors.toMap(
                        index -> ladderEdge.player(index),
                        index -> ladderEdge.reward(ladder.finalLine(index))
                ));
        return new LadderGame(result);
    }
}
