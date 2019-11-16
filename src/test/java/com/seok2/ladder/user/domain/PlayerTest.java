package com.seok2.ladder.user.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.seok2.ladder.structure.domain.Pillar;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    void descend() {
        Pillar bottom = Pillar.of();
        Pillar top = bottom.build(null, (prv) -> null);
        assertThat(Player.of(Participant.of("foo"),top).descend()).isEqualTo(bottom);
    }
}