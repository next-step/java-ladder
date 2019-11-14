package com.seok2.ladder.product.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.seok2.ladder.structure.domain.Line;
import org.junit.jupiter.api.Test;

class RewardTest {

    @Test
    void contain() {
        Line line = Line.of();
        assertThat(Reward.of(null, line).contain(line)).isTrue();
        assertThat(Reward.of(null, line).contain(Line.of())).isFalse();
    }
}