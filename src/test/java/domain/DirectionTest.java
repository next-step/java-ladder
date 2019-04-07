package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {
    @Test(expected = RuntimeException.class)
    public void point_양쪽_모두_이동선_존재() {
        new Direction(Movable.TRUE, Movable.TRUE);
    }

    @Test
    public void first_좌측이동은_항상_없음() {
        final Direction firstHasNoMove = Direction.first(Movable.FALSE);
        assertThat(firstHasNoMove.canMoveLeft()).isEqualTo(false);
        assertThat(firstHasNoMove.canMoveRight()).isEqualTo(false);

        final Direction firstHasRightMove = Direction.first(Movable.TRUE);
        assertThat(firstHasRightMove.canMoveLeft()).isEqualTo(false);
        assertThat(firstHasRightMove.canMoveRight()).isEqualTo(true);
    }

    @Test
    public void last_우측이동은_항상_없음() {
        final Direction direction1 = Direction.RIGHT;
        final Direction lastOfDirection1 = direction1.last();
        assertThat(lastOfDirection1.canMoveLeft()).isEqualTo(direction1.canMoveRight());
        assertThat(lastOfDirection1.canMoveRight()).isEqualTo(false);

        final Direction direction2 = Direction.NONE;
        final Direction lastOfDirection2 = direction2.last();
        assertThat(lastOfDirection2.canMoveLeft()).isEqualTo(direction2.canMoveRight());
        assertThat(lastOfDirection2.canMoveRight()).isEqualTo(false);
    }

    @Test
    public void next() {
        final Direction direction1 = Direction.RIGHT;
        final Direction direction2 = direction1.next(Movable.FALSE);
        assertThat(direction2.canMoveLeft()).isEqualTo(direction1.canMoveRight());
    }

    @Test(expected = RuntimeException.class)
    public void next_우측이동_이후_한번더_이동_생성() {
        final Direction direction1 = Direction.RIGHT;
        final Direction direction2 = direction1.next(Movable.TRUE);
    }
}