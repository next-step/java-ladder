package ladder.domain.ladder;

import org.junit.jupiter.api.Assertions;
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

    @Test
    void isRight() {
        Assertions.assertAll(
                () -> assertThat(HorizontalLineDirection.RIGHT.isRight()).isTrue(),
                () -> assertThat(HorizontalLineDirection.LEFT.isRight()).isFalse(),
                () -> assertThat(HorizontalLineDirection.NONE.isRight()).isFalse()
        );
    }
}
