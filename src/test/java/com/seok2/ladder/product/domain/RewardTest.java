package com.seok2.ladder.product.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.seok2.ladder.structure.domain.Pillar;
import org.junit.jupiter.api.Test;

class RewardTest {

    @Test
    void contain() {
        Pillar pillar = Pillar.of();
        assertThat(Reward.of(null, pillar).contain(pillar)).isTrue();
        assertThat(Reward.of(null, pillar).contain(Pillar.of())).isFalse();
    }
}