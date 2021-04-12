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

    @Override
    public Position getPosition() {
        return position;
    }

}
