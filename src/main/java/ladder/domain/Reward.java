package ladder.domain;

import java.util.Objects;

public class Reward {

    private String rewardInfo;

    public Reward(String result) {
        this.rewardInfo = result;
    }

    public String getRewardInfo() {
        return rewardInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reward that = (Reward) o;
        return Objects.equals(rewardInfo, that.rewardInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rewardInfo);
    }
}
