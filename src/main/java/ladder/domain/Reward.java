package ladder.domain;

import java.util.Objects;

public class Reward {

    public String rewardInfo;
    public Position position;

    public Reward(String result, int position) {
        this.rewardInfo = result;
        this.position = new Position(position);
    }

    public Position getPosition() {
        return position;
    }

    public String getRewardInfo() {
        return rewardInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reward that = (Reward) o;
        return Objects.equals(rewardInfo, that.rewardInfo) &&
                Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rewardInfo, position);
    }
}
