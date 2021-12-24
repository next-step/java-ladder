package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;

public class LadderFrame {
    private final Players players;
    // todo refactor 이게 여기 있으므로 책임과 로직이 모호해짐
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

    public Prizes prizes() {
        return prizes;
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
