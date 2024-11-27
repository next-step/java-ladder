package ladder.domain;

import java.util.Objects;

public class Result {
    private final PlayerName playerName;
    private final RewardName rewardName;

    public Result(PlayerName playerName, RewardName rewardName) {
        this.playerName = playerName;
        this.rewardName = rewardName;
    }

    public RewardName rewardName() {
        return rewardName;
    }

    public boolean isPlayerResult(PlayerName playerName) {
        return this.playerName.equals(playerName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return Objects.equals(playerName, result.playerName) && Objects.equals(rewardName, result.rewardName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName, rewardName);
    }
}
