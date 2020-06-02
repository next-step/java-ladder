package nextstep.ladder.domain;

import java.util.Objects;

public class GameResult {
    private Player player;
    private Reward reward;

    public GameResult(Player player, Reward reward) {
        this.player = player;
        this.reward = reward;
    }

    Reward getReward() {
        return this.reward;
    }

    String getPlayerName() {
        return this.player.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResult that = (GameResult) o;
        return Objects.equals(player, that.player) &&
                Objects.equals(reward, that.reward);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player, reward);
    }
}
