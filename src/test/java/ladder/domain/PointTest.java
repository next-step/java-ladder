package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    @DisplayName("Line의 첫 인덱스가 true일때 이동하면 index가 증가한다")
    void move_first_index() {
        // given
        int index = 0;
        Point point = Point.from(index, true);

        // when
        int expectedIndex = point.move();

        // then
        assertThat(++index).isEqualTo(expectedIndex);
    }

    @Test
    @DisplayName("현재 Point가 true일때 이동하면 index가 증가한다")
    void move_right() {
        // given
        int index = 1;
        Point point = Point.from(index, true);

        // when
        int expectedIndex = point.move(false);

        // then
        assertThat(++index).isEqualTo(expectedIndex);
    }

    @Test
    @DisplayName("현재 Point가 false이고 이전 Point가 true일때 이동하면 index가 감소한다")
    void move_left() {
        // given
        int index = 1;
        Point point = Point.from(1, false);

        // when
        int expectedIndex = point.move(true);

        // then
        assertThat(--index).isEqualTo(expectedIndex);
    }

    @Test
    @DisplayName("이전과 현재 Point가 모두 false 일때 이동하면 index는 변하지 않는다")
    void not_move() {
        // given
        int index = 1;
        Point point = Point.from(1, false);

        // when
        int expectedIndex = point.move(false);

        // then
        assertThat(index).isEqualTo(expectedIndex);
    }
}