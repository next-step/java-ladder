package ladder.domain.ladder.direction;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MoveHorizontalDirectionTest {

    @Test
    void create() {
        MoveHorizontalDirection moveHorizontalDirection = MoveHorizontalDirection.LEFT;

        assertThat(moveHorizontalDirection == MoveHorizontalDirection.LEFT).isTrue();
    }

    @Test
    void first() {
        assertThat(MoveHorizontalDirection.first())
                .containsOnly(MoveHorizontalDirection.STRAIGHT, MoveHorizontalDirection.RIGHT);
    }

    @Test
    void first_number() {
        assertAll(
                () -> assertThatThrownBy(
                        () -> MoveHorizontalDirection.first(-1)).isInstanceOf(IllegalArgumentException.class),
                () -> assertThat(MoveHorizontalDirection.first(0))
                        .isEqualTo(MoveHorizontalDirection.first().get(0)),
                () -> assertThat(MoveHorizontalDirection.first(1))
                        .isEqualTo(MoveHorizontalDirection.first().get(1)),
                () -> assertThatThrownBy(
                        () -> MoveHorizontalDirection.first(MoveHorizontalDirection.first().size() + 1))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void next() {
        MoveHorizontalDirection moveHorizontalDirection = MoveHorizontalDirection.LEFT;

        assertThat(moveHorizontalDirection.next())
                .containsOnly(MoveHorizontalDirection.RIGHT, MoveHorizontalDirection.STRAIGHT);

        MoveHorizontalDirection rightMoveHorizontalDirection = MoveHorizontalDirection.RIGHT;

        assertThat(rightMoveHorizontalDirection.next()).containsOnly(MoveHorizontalDirection.LEFT);
    }

    @Test
    void last() {
        MoveHorizontalDirection moveHorizontalDirection = MoveHorizontalDirection.LEFT;

        assertThat(moveHorizontalDirection.last()).isEqualTo(MoveHorizontalDirection.STRAIGHT);

        MoveHorizontalDirection rightMoveHorizontalDirection = MoveHorizontalDirection.RIGHT;

        assertThat(rightMoveHorizontalDirection.last()).isEqualTo(MoveHorizontalDirection.LEFT);
    }

    @Test
    void isCurrentRight() {
        assertAll(
                () -> assertThat(MoveHorizontalDirection.LEFT.isCurrentRight()).isFalse(),
                () -> assertThat(MoveHorizontalDirection.STRAIGHT.isCurrentRight()).isFalse(),
                () -> assertThat(MoveHorizontalDirection.RIGHT.isCurrentRight()).isTrue());
    }
}
