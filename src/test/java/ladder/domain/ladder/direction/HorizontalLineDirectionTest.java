package ladder.domain.ladder.direction;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class HorizontalLineDirectionTest {

    @Test
    void create() {
        HorizontalLineDirection horizontalLineDirection = HorizontalLineDirection.LEFT;

        assertThat(horizontalLineDirection == HorizontalLineDirection.LEFT).isTrue();
    }

    @Test
    void first() {
        assertThat(HorizontalLineDirection.first())
                .containsOnly(HorizontalLineDirection.STRAIGHT, HorizontalLineDirection.RIGHT);
    }

    @Test
    void first_number() {
        assertAll(
                () -> assertThatThrownBy(
                        () -> HorizontalLineDirection.first(-1)).isInstanceOf(IllegalArgumentException.class),
                () -> assertThat(HorizontalLineDirection.first(0))
                        .isEqualTo(HorizontalLineDirection.first().get(0)),
                () -> assertThat(HorizontalLineDirection.first(1))
                        .isEqualTo(HorizontalLineDirection.first().get(1)),
                () -> assertThatThrownBy(
                        () -> HorizontalLineDirection.first(HorizontalLineDirection.first().size() + 1))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void next() {
        HorizontalLineDirection horizontalLineDirection = HorizontalLineDirection.LEFT;

        assertThat(horizontalLineDirection.next())
                .containsOnly(HorizontalLineDirection.RIGHT, HorizontalLineDirection.STRAIGHT);

        HorizontalLineDirection rightHorizontalLineDirection = HorizontalLineDirection.RIGHT;

        assertThat(rightHorizontalLineDirection.next()).containsOnly(HorizontalLineDirection.LEFT);
    }

    @Test
    void last() {
        HorizontalLineDirection horizontalLineDirection = HorizontalLineDirection.LEFT;

        assertThat(horizontalLineDirection.last()).isEqualTo(HorizontalLineDirection.STRAIGHT);

        HorizontalLineDirection rightHorizontalLineDirection = HorizontalLineDirection.RIGHT;

        assertThat(rightHorizontalLineDirection.last()).isEqualTo(HorizontalLineDirection.LEFT);
    }

    @Test
    void isCurrentRight() {
        assertAll(
                () -> assertThat(HorizontalLineDirection.LEFT.isRight()).isFalse(),
                () -> assertThat(HorizontalLineDirection.STRAIGHT.isRight()).isFalse(),
                () -> assertThat(HorizontalLineDirection.RIGHT.isRight()).isTrue());
    }
}
