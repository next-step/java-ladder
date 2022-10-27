package ladder.domain.ladder;

import ladder.exception.ladder.LadderNumberException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class HorizontalLineDirectionTest {

    @Test
    void create() {
        Assertions.assertAll(
                () -> assertThat(HorizontalLineDirection.LEFT).isEqualTo(HorizontalLineDirection.LEFT),
                () -> assertThat(HorizontalLineDirection.LEFT).isNotEqualTo(HorizontalLineDirection.RIGHT),
                () -> assertThat(HorizontalLineDirection.LEFT).isNotEqualTo(HorizontalLineDirection.NONE)
        );
    }

    @DisplayName("Type 번호에 맞는 사다리를 반환한다.")
    @Test
    void get_ladder_type() {
        Assertions.assertAll(
                () -> assertThat(HorizontalLineDirection.of(1)).isEqualTo(HorizontalLineDirection.LEFT),
                () -> assertThat(HorizontalLineDirection.of(2)).isEqualTo(HorizontalLineDirection.RIGHT),
                () -> assertThat(HorizontalLineDirection.of(3)).isEqualTo(HorizontalLineDirection.NONE),
                () -> assertThatThrownBy(() -> HorizontalLineDirection.of(4)).isInstanceOf(LadderNumberException.class)
        );
    }
}
