package ladder.domain.result;

import java.util.Objects;

public class LadderResult {
    private String playerName;
    private String rewardPrize;

    private LadderResult(String playerName, String rewardPrize) {
        this.playerName = playerName;
        this.rewardPrize = rewardPrize;
    }

    public static LadderResult of(String playerName, String rewardPrize) {
        return new LadderResult(playerName, rewardPrize);
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getRewardPrize() {
        return rewardPrize;
    }

    @Override
    public String toString() {
        return  playerName + " : " + rewardPrize ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderResult result = (LadderResult) o;
        return Objects.equals(playerName, result.playerName) &&
                Objects.equals(rewardPrize, result.rewardPrize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName, rewardPrize);
    }
}
