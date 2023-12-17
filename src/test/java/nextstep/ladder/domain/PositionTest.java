package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    void 첫번째자리가_아니면_true() {
        Position position = new Position(1, 1);
        assertThat(position.isNotFirstPosition()).isTrue();
    }

    @Test
    void 마지막_자리가_아니라면_true() {
        Position position = new Position(0, 1);
        assertThat(position.isNotLastPosition()).isTrue();
    }
}