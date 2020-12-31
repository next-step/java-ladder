package nextstep.laddergame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SequenceTest {

    @Test
    void create() {
        assertThat(Sequence.create(1)).isNotNull();
    }
}