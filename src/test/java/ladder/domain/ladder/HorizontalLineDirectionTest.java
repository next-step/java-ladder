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
    void move() {
        Assertions.assertAll(
                () -> assertThat(HorizontalLineDirection.LEFT.move(1)).isEqualTo(0),
                () -> assertThat(HorizontalLineDirection.RIGHT.move(1)).isEqualTo(2),
                () -> assertThat(HorizontalLineDirection.NONE.move(1)).isEqualTo(1)
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
