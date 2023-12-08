package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {

    @Test
    void 선은_최소_한명이상이_있어야_만들어진다() {
        assertThatThrownBy(() -> new Line(1)).isInstanceOf(IllegalArgumentException.class);
    }
}