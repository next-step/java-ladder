package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.*;

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
}
