package ladder.domain.ladder;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class Point2Test {
    @Test
    public void 생성시_index가_0미만일_경우_IllegalArgumentException() {
        // given
        Direction direction = new Direction(false, false);
        int index = -1;

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Point2(index, direction));
    }

    @Test
    public void 첫번째_Point의_index는_0() {
        // given
        Point2 firstPoint = Point2.first(false);

        // when
        int firstIndex = firstPoint.getIndex();

        // then
        assertThat(firstIndex).isEqualTo(0);
    }

    @Test
    public void 다음_Point의_Direction_left는_이전_Point의_Direction_right를_따라감() {
        // given
        boolean rightOfPreviousPoint = true;
        Point2 point = new Point2(1, new Direction(false, rightOfPreviousPoint));

        // when
        Point2 lastPoint = point.next(false);

        // then
        assertThat(lastPoint.getIndex()).isEqualTo(point.getIndex() + 1);
        assertThat(lastPoint.canMoveLeft()).isEqualTo(rightOfPreviousPoint);
    }

    @Test
    public void 마지막_Point() {
        // given
        boolean rightOfPreviousPoint = false;
        Point2 point = new Point2(1, new Direction(false, rightOfPreviousPoint));

        // when
        Point2 lastPoint = point.last();

        // then
        assertThat(lastPoint.getIndex()).isEqualTo(point.getIndex() + 1);
        assertThat(lastPoint.canMoveLeft()).isEqualTo(rightOfPreviousPoint);
        assertThat(lastPoint.canMoveRight()).isFalse();
    }

    @Test
    public void move_왼쪽_이동() {
        // given
        int initialIndex = 2;
        Direction direction = new Direction(true, false);
        Point2 point2 = new Point2(initialIndex, direction);

        // when
        int index = point2.move();

        // then
        assertThat(index).isEqualTo(initialIndex - 1);
    }

    @Test
    public void move_오른쪽_이동() {
        // given
        int initialIndex = 2;
        Direction direction = new Direction(false, true);
        Point2 point2 = new Point2(initialIndex, direction);

        // when
        int index = point2.move();

        // then
        assertThat(index).isEqualTo(initialIndex + 1);
    }

    @Test
    public void move_제자리() {
        // given
        int initialIndex = 2;
        Direction direction = new Direction(false, false);
        Point2 point = new Point2(initialIndex, direction);

        // when
        int index = point.move();

        // then
        assertThat(index).isEqualTo(initialIndex);
    }
}
