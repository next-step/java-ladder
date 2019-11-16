package com.seok2.ladder.structure.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PillarTest {

    @Test
    void isLink() {
        Pillar previous = Pillar.of().build(null, (prv) -> null);
        assertThat(previous.isLung()).isFalse();
    }

    @Test
    void isNotLung() {
        Pillar previous = Pillar.of().build(null, (prv) -> null);
        Pillar pillar = Pillar.of().build(previous, (prv) -> previous);
        assertThat(previous.isLung()).isTrue();
        assertThat(pillar.isLung()).isTrue();
    }

    @Test
    void down() {
        Pillar bottom = Pillar.of();
        Pillar top = bottom.build(null, (prv) -> null);
        assertThat(top.down()).isEqualTo(bottom);
    }

    @Test
    void next_vertical() {
        Pillar bottom = Pillar.of();
        Pillar top = bottom.build(null, (prv) -> null);
        assertThat(top.next()).isEqualTo(bottom);
    }

    @Test
    void next_horizontal() {
        Pillar target = Pillar.of();
        Pillar previous = target.build(null, (prv) -> null);
        Pillar top = Pillar.of().build(previous, (prv) -> previous);
        assertThat(top.next()).isEqualTo(target);
    }
}