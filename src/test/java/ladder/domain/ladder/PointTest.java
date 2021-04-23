package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @DisplayName("Point 인스턴스가 오른쪽으로 이동하는지 테스트")
    @Test
    void right() {
        // given
        int position = 1;
        int executed = 2;
        Direction right = Direction.first(true);

        // when
        Point point = new Point(position, right);

        // then
        assertThat(point.move()).isEqualTo(executed);
    }

    @DisplayName("Point 인스턴스가 왼쪽으로 이동하는지 테스트")
    @Test
    void left() {
        // given
        int position = 1;
        int executed = 0;
        Direction left = Direction.first(true).next(false);

        // when
        Point point = new Point(position, left);

        // then
        assertThat(point.move()).isEqualTo(executed);
    }


    @DisplayName("Point 인스턴스가 그대로 아래로 이동하는지 테스트")
    @Test
    void pass() {
        // given
        int position = 1;
        int executed = 1;
        Direction pass = Direction.first(false);

        // when
        Point point = new Point(position, pass);

        // then
        assertThat(point.move()).isEqualTo(executed);
    }
}