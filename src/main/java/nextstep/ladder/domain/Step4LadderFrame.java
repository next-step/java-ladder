package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;

import nextstep.ladder.engine.LadderFrame;

public class Step4LadderFrame implements LadderFrame {
    private final LadderPlayers ladderPlayers;
    // todo refactor 이게 여기 있으므로 책임과 로직이 모호해짐
    private final LadderPrizes ladderPrizes;

    private Step4LadderFrame(LadderPlayers ladderPlayers, LadderPrizes ladderPrizes) {
        this.ladderPlayers = ladderPlayers;
        this.ladderPrizes = ladderPrizes;
    }

    public static Step4LadderFrame of(List<String> players, List<String> results) {
        if (players == null || results == null) {
            throw new IllegalArgumentException("players or results cannot be null");
        }

        if (players.size() != results.size()) {
            throw new IllegalArgumentException("players and results count is not matched");
        }

        return new Step4LadderFrame(LadderPlayers.of(players), LadderPrizes.fromString(results));
    }

    public LadderPlayers players() {
        return ladderPlayers;
    }

    public LadderPrizes prizes() {
        return ladderPrizes;
    }

    public LadderRailCount railCount() {
        return LadderRailCount.of(ladderPlayers.size());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Step4LadderFrame that = (Step4LadderFrame) o;
        return Objects.equals(ladderPlayers, that.ladderPlayers) && Objects.equals(ladderPrizes, that.ladderPrizes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderPlayers, ladderPrizes);
    }

    @Override
    public String toString() {
        return "LadderFrame{" +
                "players=" + ladderPlayers +
                ", results=" + ladderPrizes +
                '}';
    }
}
