package com.seok2.ladder.structure.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RungTest {

    @Test
    void left() {
        Rung left = Rung.left(null);
        assertThat(left.isLeft()).isTrue();
    }

    @Test
    void right() {
        Rung left = Rung.right(null);
        assertThat(left.isLeft()).isFalse();
    }

    @Test
    void move() {
        Pillar bottom = Pillar.of();
        Pillar top = bottom.build(null, (prv) -> null);
        assertThat(Rung.left(top).move()).isEqualTo(bottom);
    }
}