package nextstep.ladder.domain;

import java.util.Objects;

public class LadderFrame {
    public static final int MINIMUM_RAIL_COUNT = 2;

    private final Players players;
    private final Results results;

    private LadderFrame(Players players, Results results) {
        this.players = players;
        this.results = results;
    }

    public static LadderFrame of(Players players, Results results) {
        if (players == null || results == null) {
            throw new IllegalArgumentException("players or results cannot be null");
        }

        // todo count를 꺼내야하나??
        if (!players.count().equalValue(results.count())) {
            throw new IllegalArgumentException("players and results count is not matched");
        }

        return new LadderFrame(players, results);
    }

    public Players players() {
        return players;
    }

    public Results results() {
        return results;
    }

    public PlayerCount playerCount() {
        return players.count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderFrame that = (LadderFrame) o;
        return Objects.equals(players, that.players) && Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players, results);
    }

    @Override
    public String toString() {
        return "LadderFrame{" +
                "players=" + players +
                ", results=" + results +
                '}';
    }
}
