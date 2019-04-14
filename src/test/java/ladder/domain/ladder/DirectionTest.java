package ladder.domain.ladder;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

public class DirectionTest {
    @Test
    public void 양쪽_모두_true일_경우_IllegalStateException() {
        // when
        // then
        assertThatIllegalStateException().isThrownBy(() -> new Direction(true, true));
    }

    @Test
    public void 첫번째_Direction은_왼쪽이_false() {
        // given
        Direction firstDirection = Direction.first(true);

        // when
        boolean isLeft = firstDirection.isLeft();

        // then
        assertThat(isLeft).isFalse();
    }

    @Test
    public void 다음_Direction의_left는_이전_Direction의_right를_따라감() {
        // given
        boolean rightOfPreviousDirection = true;
        Direction direction = new Direction(false, rightOfPreviousDirection);

        // when
        Direction nextDirection = direction.next(false);

        // then
        assertThat(nextDirection.isLeft()).isEqualTo(rightOfPreviousDirection);
    }

    @Test
    public void 마지막_Direction() {
        // given
        boolean rightOfPreviousDirection = false;
        Direction direction = new Direction(false, rightOfPreviousDirection);

        // when
        Direction lastDirection = direction.last();

        // then
        assertThat(lastDirection.isLeft()).isEqualTo(rightOfPreviousDirection);
        assertThat(lastDirection.isRight()).isFalse();
    }
}
