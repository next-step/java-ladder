package com.fineroot.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.fineroot.ladder.engine.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RewardsTest {
    @Test
    @DisplayName("Rewards 생성")
    void create() {
        assertThat(Rewards.fromString("꽝,5000,꽝,3000")).hasToString("    꽝  5000     꽝  3000");
    }

    @Test
    @DisplayName("reward 문자열")
    void rewardString() {
        assertThat(Rewards.fromString("꽝,5000,꽝,3000").rewardString(new Position(1))).isEqualTo("5000");
    }

    @Test
    @DisplayName("총 크기")
    void size() {
        assertThat(Rewards.fromString("꽝,5000,꽝,3000").size()).isEqualTo(4);
    }
}
