package com.seok2.ladder.structure.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    void isLink() {
        Line previous = Line.of().build(null, (prv) -> null);
        assertThat(previous.isLung()).isFalse();
    }

    @Test
    void isNotLung() {
        Line previous = Line.of().build(null, (prv) -> null);
        Line line = Line.of().build(previous, (prv) -> previous);
        assertThat(previous.isLung()).isTrue();
        assertThat(line.isLung()).isTrue();
    }

    @Test
    void down() {
        Line bottom = Line.of();
        Line top = bottom.build(null, (prv) -> null);
        assertThat(top.down()).isEqualTo(bottom);
    }

    @Test
    void next_vertical() {
        Line bottom = Line.of();
        Line top = bottom.build(null, (prv) -> null);
        assertThat(top.next()).isEqualTo(bottom);
    }

    @Test
    void next_horizontal() {
        Line target = Line.of();
        Line previous = target.build(null, (prv) -> null);
        Line top = Line.of().build(previous, (prv) -> previous);
        assertThat(top.next()).isEqualTo(target);
    }
}