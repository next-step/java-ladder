package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MoveHorizontalDirectionTest {

    @Test
    void create() {
        MoveHorizontalDirection moveHorizontalDirection
                = new MoveHorizontalDirection(HorizontalLineDirection.RIGHT, HorizontalLineDirection.LEFT);

        assertThat(moveHorizontalDirection)
                .isEqualTo(new MoveHorizontalDirection(HorizontalLineDirection.RIGHT, HorizontalLineDirection.LEFT));
    }

    @Test
    void first() {
        assertThat(MoveHorizontalDirection.first())
                .containsOnly(new MoveHorizontalDirection(HorizontalLineDirection.NONE, HorizontalLineDirection.NONE),
                        new MoveHorizontalDirection(HorizontalLineDirection.NONE, HorizontalLineDirection.RIGHT));
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
        MoveHorizontalDirection moveHorizontalDirection
                = new MoveHorizontalDirection(HorizontalLineDirection.RIGHT, HorizontalLineDirection.LEFT);

        assertThat(moveHorizontalDirection.next()).containsOnly(
                new MoveHorizontalDirection(HorizontalLineDirection.LEFT, HorizontalLineDirection.RIGHT),
                new MoveHorizontalDirection(HorizontalLineDirection.LEFT, HorizontalLineDirection.NONE));

        MoveHorizontalDirection rightMoveHorizontalDirection
                = new MoveHorizontalDirection(HorizontalLineDirection.NONE, HorizontalLineDirection.RIGHT);

        assertThat(rightMoveHorizontalDirection.next()).containsOnly(
                new MoveHorizontalDirection(HorizontalLineDirection.RIGHT, HorizontalLineDirection.LEFT));
    }

    @Test
    void last() {
        MoveHorizontalDirection moveHorizontalDirection
                = new MoveHorizontalDirection(HorizontalLineDirection.RIGHT, HorizontalLineDirection.LEFT);

        assertThat(moveHorizontalDirection.last()).isEqualTo(
                new MoveHorizontalDirection(HorizontalLineDirection.LEFT, HorizontalLineDirection.NONE));

        MoveHorizontalDirection rightMoveHorizontalDirection
                = new MoveHorizontalDirection(HorizontalLineDirection.NONE, HorizontalLineDirection.RIGHT);

        assertThat(rightMoveHorizontalDirection.last()).isEqualTo(
                new MoveHorizontalDirection(HorizontalLineDirection.RIGHT, HorizontalLineDirection.LEFT));
    }

    @Test
    void isCurrentRight() {
        assertAll(
                () -> assertThat(
                        new MoveHorizontalDirection(HorizontalLineDirection.RIGHT, HorizontalLineDirection.LEFT)
                                .isCurrentRight())
                        .isFalse(),
                () -> assertThat(
                        new MoveHorizontalDirection(HorizontalLineDirection.RIGHT, HorizontalLineDirection.NONE)
                                .isCurrentRight())
                        .isFalse(),
                () -> assertThat(
                        new MoveHorizontalDirection(HorizontalLineDirection.RIGHT, HorizontalLineDirection.RIGHT)
                                .isCurrentRight())
                        .isTrue()
        );
    }
}
