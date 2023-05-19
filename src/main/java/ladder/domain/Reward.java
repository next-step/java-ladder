package ladder.domain;

public class Reward
{

    private final static String NUMBER_REGEX = "^[0-9]*$";
    private final static String NO_LUCK = "꽝";
    private final static String EXCEPTION_MESSAGE_REWARD = "금액 또는 꽝만 입력이 가능합니다. 현재 입력된 경품 : ";
    private final String ladderReward;

    public Reward(String ladderReward) {
        validateReward(ladderReward);

        this.ladderReward = ladderReward;
    }

    public String reward() {
        return ladderReward;
    }

    private void validateReward(String ladderReward) {
        if (!isReward(ladderReward)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_REWARD + ladderReward);
        }
    }

    private boolean isReward(String ladderReward) {
        return ladderReward.equals(NO_LUCK) || ladderReward.matches(NUMBER_REGEX);
    }

}
