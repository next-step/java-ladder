package nextstep.refactoring.laddergame.engine.reward;

import nextstep.refactoring.ladder.engine.Position;
import nextstep.refactoring.laddergame.engine.Positionable;

import java.util.Objects;

public class Reward implements Positionable {

    private final RewardString rewardString;
    private final Position position;

    public Reward(RewardString rewardString, Position position) {
        this.rewardString = rewardString;
        this.position = position;
    }

    public static Reward of(String rewardString, Position position) {
        return new Reward(RewardString.of(rewardString), position);
    }

    public static Reward of(String rewardString, int position) {
        return Reward.of(rewardString, Position.of(position));
    }

    public String getRewardString() {
        return rewardString.toString();
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Reward)) {
            return false;
        }
        Reward reward = (Reward) o;
        return Objects.equals(rewardString, reward.rewardString) && Objects
            .equals(getPosition(), reward.getPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(rewardString, getPosition());
    }
}
