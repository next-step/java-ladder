package ladder.domain.result;

import ladder.domain.player.Player;
import ladder.domain.reward.Reward;

import java.util.Objects;

public class LadderResult {
    private Player player;
    private Reward reward;

    private LadderResult(Player player, Reward reward) {
        this.player = player;
        this.reward = reward;
    }

    public static LadderResult of(Player player, Reward rewardPrize) {
        return new LadderResult(player, rewardPrize);
    }

    public boolean isMatchesName(String name) {
        return player.isMatchesName(name);
    }

    public String getPlayerName() {
        return player.getName();
    }

    public String getRewardPrize() {
        return reward.getName();
    }

    @Override
    public String toString() {
        return  getPlayerName() + " : " + getRewardPrize() ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderResult result = (LadderResult) o;
        return Objects.equals(player, result.player) &&
                Objects.equals(reward, result.reward);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player, reward);
    }
}
