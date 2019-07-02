package com.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ResultTest {

    @DisplayName("플레이어와 보상을 입력받는데 성공한다")
    @Test
    void createResult_inputPlayersAndRewards_success() {
        // given
        Players players = Players.of("a,b,c,d");
        Rewards rewards = Rewards.of("1등,꽝,2등,꽝");

        // when
        Result result = Result.of(players, rewards);

        // then
        assertThat(result).isNotNull();
    }

    @DisplayName("플레이어 수와 보상 수가 다를 경우 생성에 실패한다")
    @Test
    void createResult_whenNumberDoesNotMatch_exception() {
        // given
        Players players = Players.of("a,b,c");
        Rewards rewards = Rewards.of("1등,꽝,2등,꽝");

        // exception
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Result.of(players, rewards));
    }
}