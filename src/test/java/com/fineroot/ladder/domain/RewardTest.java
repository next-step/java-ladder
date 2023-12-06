package com.fineroot.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.fineroot.ladder.utils.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RewardTest {
    @Test
    @DisplayName("Reward 생성")
    void create() {
        assertThat(new Reward("꽝")).hasToString("꽝");
    }

    @ParameterizedTest
    @DisplayName("Reward 생성 도중 빈칸 또는 공백시 예외 발생")
    @ValueSource(strings = {""," "})
    void create_exception(String input) {
        assertThatThrownBy(()->new Reward(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.REWARD_EMPTY_OR_BLANK.getMessage());
    }
}
