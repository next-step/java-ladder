package com.seok2.ladder.structure.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    void isLink() {
        Line previous = Line.of().build(null, (prv) -> null);
        assertThat(previous.isLink()).isFalse();
        Line line = Line.of().build(previous, (prv) -> previous);
        assertThat(previous.isLink()).isTrue();
        assertThat(line.isLink()).isTrue();
    }
}