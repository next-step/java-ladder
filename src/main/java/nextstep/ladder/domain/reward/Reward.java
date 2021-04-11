package nextstep.ladder.domain.reward;

public class Reward {

    private final RewardString rewardString;

    private Reward(RewardString rewardString) {
        this.rewardString = rewardString;
    }

    public static Reward of(String rewardString) {
        return new Reward(RewardStringFactory.createRewardString(rewardString));
    }

    public String export() {
        return rewardString.export();
    }

}
