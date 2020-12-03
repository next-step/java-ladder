package step2.domain;

import java.util.Objects;

public class GameResult {
    private final PlayerGameName playerGameName;
    private final Reward reward;

    private GameResult(final PlayerGameName playerGameName, final Reward reward) {
        this.playerGameName = playerGameName;
        this.reward = reward;
    }

    public static GameResult of(final String playerGameName, final String reward) {
        return new GameResult(PlayerGameName.of(playerGameName), Reward.of(reward));
    }

    public String getPlayerGameName() {
        return playerGameName.getName();
    }

    public String getRewardName() {
        return reward.getRewardName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResult that = (GameResult) o;
        return Objects.equals(playerGameName, that.playerGameName) &&
                Objects.equals(reward, that.reward);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerGameName, reward);
    }
}
