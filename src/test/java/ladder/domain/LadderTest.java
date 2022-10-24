package ladder.domain;

import ladder.domain.Ladder.Ladder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LadderTest {

    @Test
    void create() {
        Assertions.assertAll(
                () -> assertThat(Ladder.LEFT).isEqualTo(Ladder.LEFT),
                () -> assertThat(Ladder.LEFT).isNotEqualTo(Ladder.RIGHT),
                () -> assertThat(Ladder.LEFT).isNotEqualTo(Ladder.NONE)
        );
    }
}