package com.seok2.ladder.user.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.seok2.ladder.structure.domain.Line;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    void descend() {
        Line bottom = Line.of();
        Line top = bottom.build(null, (prv) -> null);
        assertThat(Player.of(Participant.of("foo"),top).descend()).isEqualTo(bottom);
    }
}