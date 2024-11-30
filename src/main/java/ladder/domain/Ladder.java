package ladder.domain;

import ladder.domain.generator.CrossGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    public static final int START_INCLUSIVE = 0;
    private final Lines lines;
    private final Players players;

    public Ladder(Players players, int verticalLadderSize, CrossGenerator generator) {
        this(players, new Lines(players, verticalLadderSize, generator));
    }

    public Ladder(Players players, Lines lines) {
        this.players = players;
        this.lines = lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }

    public Lines getLines() {
        return lines;
    }

    public Players getPlayers() {
        return players;
    }

    public Results results(Rewards rewards) {
        Players endPlayers = lines.move(players);
        Map<PlayerName, RewardName> results = new HashMap<>();
        IntStream.range(START_INCLUSIVE, endPlayers.size())
                .boxed()
                .forEach(index -> {
                    PlayerName key = endPlayers.names().get(index);
                    System.out.println("key = " + key);
                    RewardName value = rewards.names().get(index);
                    System.out.println("value = " + value);
                    results.put(key, value);
                });
        return new Results(results);
    }
}
