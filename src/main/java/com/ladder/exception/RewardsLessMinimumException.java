package com.ladder.exception;

import static com.ladder.model.Rewards.MIN_NUMBER_OF_REWARDS;

public class RewardsLessMinimumException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "보상은 %d명 이상 이어야 합니다.";

    public RewardsLessMinimumException() {
        super(String.format(ERROR_MESSAGE, MIN_NUMBER_OF_REWARDS));
    }
}
