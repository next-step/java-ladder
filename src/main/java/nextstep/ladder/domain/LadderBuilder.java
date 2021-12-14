package nextstep.ladder.domain;

import java.util.Objects;

import nextstep.ladder.domain.line.LineGenerateStrategy;

public class LadderBuilder {
    public static final int MINIMUM_RAIL_COUNT = 2;

    private final Players players;
    private final Results results;

    private LadderBuilder(final Players players, final Results results) {
        this.players = players;
        this.results = results;
    }

    public static LadderBuilder of(Players players, Results results) {
        if (players == null || results == null) {
            throw new IllegalArgumentException("invalid input: players or results cannot be null");
        }

        if (!players.count().equalValue(results.count())) {
            throw new IllegalArgumentException("invalid input: player count and result count must be same");
        }

        return new LadderBuilder(players, results);
    }

    public Ladder build(int height, LineGenerateStrategy strategy) {
        return Ladder.of(players.count(), Height.of(height), strategy);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderBuilder that = (LadderBuilder) o;
        return Objects.equals(players, that.players) && Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players, results);
    }
}
