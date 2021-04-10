package nextstep.ladder.domain.reward;

public class BlankReward implements RewardString {

    static final String BLANK_REWARD_STRING = "꽝";

    public BlankReward(String reward) {
        validate(reward);
    }

    private static void validate(String reward) {
        if (!reward.equals(BLANK_REWARD_STRING)) {
            throw new IllegalArgumentException("'꽝' 이외에 다른 단어는 사용할 수 없습니다.");
        }
    }

    @Override
    public String export() {
        return BLANK_REWARD_STRING;
    }
}
