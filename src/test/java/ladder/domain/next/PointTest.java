package ladder.domain.next;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @DisplayName("첫 point 에서 이동하면 방향에 따라 오른쪽으로 이동하거나 제자리에 있는다")
    @Test
    public void first() {
        assertThat(Point.first(true).move()).isEqualTo(1);
        assertThat(Point.first(false).move()).isEqualTo(0);
    }

    @DisplayName("좌,우 이동할수 있는 길이 없으면 제자리에 머문다")
    @Test
    public void next_stay() {
        Point second = Point.first(false).next(false);
        assertThat(second.move()).isEqualTo(1);
    }

    @DisplayName("좌로 이동할 수 있으면 이동한다")
    @Test
    public void next_left() {
        Point second = Point.first(true).next(false);
        assertThat(second.move()).isEqualTo(0);
    }

    @DisplayName("우로 이동할 수 있으면 이동한다")
    @Test
    public void next_right() {
        Point second = Point.first(false).next(true);
        assertThat(second.move()).isEqualTo(2);
    }

    @DisplayName("오른쪽으로 이동가능한 위치의 next Point 에서는 항상 왼쪽으로 이동한다")
    @Test
    public void next() {
        Point second = Point.first(true).next();
        assertThat(second.move()).isEqualTo(0);
    }

    @DisplayName("last Point 에서는 오른쪽으로 이동할 수 없다")
    @Test
    public void last(){
        Point last = Point.first(false).next(true).last();
        assertThat(last.move()).isEqualTo(1);

        last = Point.first(false).next(false).last();
        assertThat(last.move()).isEqualTo(2);
    }

}