package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;

public class LadderFrame {
    private final Players players;
    private final Results results;

    private LadderFrame(Players players, Results results) {
        this.players = players;
        this.results = results;
    }

    public static LadderFrame of(List<String> players, List<String> results) {
        if (players == null || results == null) {
            throw new IllegalArgumentException("players or results cannot be null");
        }

        if (players.size() != results.size()) {
            throw new IllegalArgumentException("players and results count is not matched");
        }

        return new LadderFrame(Players.of(players), Results.fromString(results));
    }

    public Players players() {
        return players;
    }

    public Results results() {
        return results;
    }

    // todo 이렇게 하면 구조는 깔끔해지지만 LadderFrame의 책임이 많아지고 이름과 책임이 맞지 않음
    public Results resultsOfGame(List<Integer> indexes) {
        return results.mapByIndex(indexes);
    }

    public RailCount railCount() {
        return RailCount.of(players.size());
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
