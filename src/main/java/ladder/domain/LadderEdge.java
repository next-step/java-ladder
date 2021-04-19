package ladder.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderEdge {

    private final Players players;
    private final Rewards rewards;

    public LadderEdge(Players players, Rewards rewards) {
        this.players = players;
        this.rewards = rewards;
    }

    public Map<String, String> gameResult(Ladder ladder) {
        return IntStream.range(0, top.size())
                .boxed()
                .collect(Collectors.toMap(
                        index -> top.get(index),
                        index -> bottom.get(ladder.finalLine(index)))
                );
    }

    public List<String> getTop() {
        return this.top;
    }

    public List<String> getBottom() {
        return this.bottom;
    }
}
