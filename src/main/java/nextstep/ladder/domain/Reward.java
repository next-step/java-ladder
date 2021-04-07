package nextstep.ladder.domain;

import nextstep.ladder.dto.RewardDto;

public class Reward {

    private static final int MINIMUM_AMOUNT = 0;
    private static final int MAXIMUM_AMOUNT = 9999;
    private static final String LOSING_STRING = "꽝";

    private final String rewardStr;

    public Reward(String rewardStr) {
        validate(rewardStr);
        this.rewardStr = rewardStr;
    }

    private void validate(String rewardStr) {
        try {
            validateAmount(rewardStr);
        } catch (NumberFormatException e) {
            validateLosingString(rewardStr);
        }
    }

    private void validateAmount(String rewardStr) {
        int amount = Integer.parseInt(rewardStr);

        if (amount < MINIMUM_AMOUNT || MAXIMUM_AMOUNT < amount) {
            throw new IllegalArgumentException("보상 금액은 네 자릿수만 입력할 수 있습니다.");
        }
    }

    private void validateLosingString(String rewardStr) {
        if (!rewardStr.equals(LOSING_STRING)) {
            throw new IllegalArgumentException("정수가 아닌 문자열은 '꽝' 만 허용됩니다.");
        }
    }

    public RewardDto export() {
        return new RewardDto(rewardStr);
    }

}
