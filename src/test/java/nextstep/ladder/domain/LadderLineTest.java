package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderLineTest {

    @Test
    void create() {
        LadderLine ladderLine = LadderLine.of(9);

        assertThat(ladderLine.copy().size()).isEqualTo(8);
    }
}
