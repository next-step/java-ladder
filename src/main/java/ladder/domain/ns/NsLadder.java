package ladder.domain.ns;

import ladder.domain.engine.*;
import ladder.domain.engine.generator.CrossGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class NsLadder implements Ladder {
    public static final int START_INCLUSIVE = 0;
    private final Lines lines;
    private final Players players;

    public NsLadder(Players players, int verticalLadderSize, CrossGenerator generator) {
        this(players, new NsLines(players, verticalLadderSize, generator));
    }

    public NsLadder(Players players, Lines lines) {
        this.players = players;
        this.lines = lines;
    }

    @Override
    public Lines getLines() {
        return lines;
    }

    @Override
    public Players getPlayers() {
        return players;
    }

    @Override
    public Results playResults(Rewards rewards) {
        Players endPlayers = lines.move(players);
        Map<PlayerName, RewardName> results = new HashMap<>();
        IntStream.range(START_INCLUSIVE, endPlayers.size())
                .boxed()
                .forEach(index -> {
                    PlayerName key = endPlayers.names().get(index);
                    RewardName value = rewards.names().get(index);
                    results.put(key, value);
                });
        return new Results(results);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NsLadder ladder = (NsLadder) o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
