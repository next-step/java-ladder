package com.ladder.model;

import com.ladder.exception.RewardsLessMinimumException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static com.ladder.model.Rewards.MIN_NUMBER_OF_REWARDS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class RewardsTest {

    @DisplayName("콤마를 기준으로 여러 보상을 생성하는데 성공한다")
    @Test
    void createRewards_whenManyNames_success() {
        // given
        String rewards = "꽝,1등,2등,3등,꽝";
        int expectedSize = 5;

        // when
        Rewards result = Rewards.of(rewards);

        // then
        assertThat(result.getRewards()).contains(Reward.of("꽝"),
                Reward.of("1등"),
                Reward.of("2등"),
                Reward.of("3등"),
                Reward.of("꽝"));
        assertThat(result.getRewards()).hasSize(expectedSize);
    }

    @DisplayName("보상이 " + MIN_NUMBER_OF_REWARDS + "개미만 일 시 생성에 실패한다")
    @Test
    void createRewards_whenOneReward_exception() {
        String oneReward = "꽝";
        assertThatExceptionOfType(RewardsLessMinimumException.class)
                .isThrownBy(() -> Rewards.of(oneReward));
    }

    @DisplayName("보상 생성 시 공백 및 null 일 시 실패한다")
    @ParameterizedTest
    @NullAndEmptySource
    void createRewards_whenEmptyOrNull_exception(String wrongRewards) {
        assertThatExceptionOfType(AssertionError.class)
                .isThrownBy(() -> Rewards.of(wrongRewards));
    }
}