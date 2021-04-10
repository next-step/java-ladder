package nextstep.ladder.domain.reward;

class RewardStringFactory {

    private RewardStringFactory() {}

    static RewardString createRewardString(String reward) {
        try {
            return createRewardAmount(reward);
        } catch (NumberFormatException e) {
            return createBlackReward(reward);
        }
    }

    private static RewardString createRewardAmount(String reward) {
        return new RewardAmount(reward);
    }

    private static RewardString createBlackReward(String reward) {
        return new BlankReward(reward);
    }


}
