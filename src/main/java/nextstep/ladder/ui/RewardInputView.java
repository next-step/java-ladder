package nextstep.ladder.ui;

import nextstep.ladder.domain.reward.Rewards;

import java.util.Scanner;

public class RewardInputView {
    private static final String REWARD_REQUEST_COMMENT = System.lineSeparator() +
            "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";

    private Rewards rewards;

    RewardInputView(String rewardValues) {
        validate(rewardValues);
        this.rewards = Rewards.create(rewardValues);
    }

    public static RewardInputView createByUserInput(Scanner scanner) {
        System.out.println(REWARD_REQUEST_COMMENT);
        return new RewardInputView(scanner.nextLine());
    }

    public Rewards getRewards() {
        return rewards;
    }

    private void validate(String rewardValues) {
        if (rewardValues == null) {
            throw new IllegalArgumentException("Input value must not be null");
        }
        if (rewardValues.trim().isEmpty()) {
            throw new IllegalArgumentException("Input value must not empty");
        }
    }
}
