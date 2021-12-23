package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;

public class LadderFrame {
    private final Players players;
    private final Prizes prizes;

    private LadderFrame(Players players, Prizes prizes) {
        this.players = players;
        this.prizes = prizes;
    }

    public static LadderFrame of(List<String> players, List<String> results) {
        if (players == null || results == null) {
            throw new IllegalArgumentException("players or results cannot be null");
        }

        if (players.size() != results.size()) {
            throw new IllegalArgumentException("players and results count is not matched");
        }

        return new LadderFrame(Players.of(players), Prizes.fromString(results));
    }

    public Players players() {
        return players;
    }

    public Prizes results() {
        return prizes;
    }

    // todo 이렇게 하면 구조는 깔끔해지지만 LadderFrame의 책임이 많아지고 이름과 책임이 맞지 않음
    public Prizes resultsOfGame(List<Integer> indexes) {
        return prizes.mapByIndex(indexes);
    }

    public RailCount railCount() {
        return RailCount.of(players.size());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderFrame that = (LadderFrame) o;
        return Objects.equals(players, that.players) && Objects.equals(prizes, that.prizes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players, prizes);
    }

    @Override
    public String toString() {
        return "LadderFrame{" +
                "players=" + players +
                ", results=" + prizes +
                '}';
    }
}
