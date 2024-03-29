package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    void 사다리를_생성한다() {
        final Ladder ladder = new Ladder(4, 5);

        assertThat(ladder.getLines()).hasSize(5);
    }
}
