package com.ladder.model;

import com.ladder.exception.NameLengthException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.ladder.model.Reward.LENGTH_OF_REWARD_NAME;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class RewardTest {

    @DisplayName("보상을 생성한다")
    @Test
    void createReward_success() {
        // given
        String reward = "꽝";

        // when
        Reward result = Reward.of(reward);

        // then
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(Reward.of(reward));
    }

    @DisplayName("보상 이름이 " + LENGTH_OF_REWARD_NAME + "초과할 시 실패한다")
    @ParameterizedTest
    @ValueSource(strings = {"abcdef"})
    void createUsername_whenLengthMoreThanFive_exception(String wrongName) {
        assertThatExceptionOfType(NameLengthException.class)
                .isThrownBy(() -> Reward.of(wrongName));
    }

    @DisplayName("보상 이름이 빈 문자열 또는 null 일 시 실패한다")
    @ParameterizedTest
    @NullAndEmptySource
    void createUsername_whenInputEmptyOrNull_exception(String nullName) {
        assertThatExceptionOfType(AssertionError.class)
                .isThrownBy(() -> Reward.of(nullName));
    }
}