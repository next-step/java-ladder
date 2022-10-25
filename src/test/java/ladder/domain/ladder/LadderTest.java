package ladder.domain.ladder;

import ladder.exception.ladder.LadderNumberException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
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

    @DisplayName("Type 번호에 맞는 사다리를 반환한다.")
    @Test
    void get_ladder_type() {
        Assertions.assertAll(
                () -> assertThat(Ladder.of(1)).isEqualTo(Ladder.LEFT),
                () -> assertThat(Ladder.of(2)).isEqualTo(Ladder.RIGHT),
                () -> assertThat(Ladder.of(3)).isEqualTo(Ladder.NONE),
                () -> assertThatThrownBy(() -> Ladder.of(4)).isInstanceOf(LadderNumberException.class)
        );
    }
}
