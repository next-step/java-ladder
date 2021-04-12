package nextstep.refactoring.laddergame.concrete.reward;

public class Reward {

    private final RewardString rewardString;

    private Reward(RewardString rewardString) {
        this.rewardString = rewardString;
    }

    public static Reward of(String rewardString) {
        return new Reward(RewardString.of(rewardString));
    }
}
