package ladder.domain;

import java.util.Map;
import java.util.Objects;
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

    public Reward findReward(Player player) {
        return gameResult.get(player);
    }

    public Map<Player, Reward> gameResult() {
        return this.gameResult;
    }

    public String printGameResult() {
        return "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LadderGame that = (LadderGame) o;
        return Objects.equals(gameResult, that.gameResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameResult);
    }
}
