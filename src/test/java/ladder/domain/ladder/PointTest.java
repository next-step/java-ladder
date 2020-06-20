package ladder.domain.ladder;

import ladder.domain.strategy.RandomLineStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    @DisplayName("첫번째 포인트 생성 테스트")
    public void generateFirstPoint() {
        assertThat(Point.first(true).move()).isEqualTo(1);
        assertThat(Point.first(false).move()).isEqualTo(0);
    }

    @Test
    @DisplayName("연결되지 않은 포인트에서는 움직이 않음")
    public void stayPointWhenNoneDirection() {
        Point second = Point.first(false).next(false);
        assertThat(second.move()).isEqualTo(1);
    }

    @Test
    @DisplayName("왼쪽으로 연결된 포인트에서는 왼쪽으로 움직임")
    public void moveLeftWhenLeftDirection() {
        Point second = Point.first(true).next(false);
        assertThat(second.move()).isEqualTo(0);
    }

    @Test
    @DisplayName("오른쪽으로 연결된 포인트에서는 오른쪽으로 움직임")
    public void next_right() {
        Point second = Point.first(false).next(true);
        assertThat(second.move()).isEqualTo(2);
    }

    @Test
    @DisplayName("next method 로 Point 생성")
    public void testNext() {
        Point second = Point.first(true).next(new RandomLineStrategy());
        assertThat(second.move()).isEqualTo(0);
    }

    @Test
    @DisplayName("last method 로 Point 생성")
    public void testLast() {
        Point second = Point.first(true).last();
        assertThat(second.move()).isEqualTo(0);
    }
}
