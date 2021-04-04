package step4_ladderGame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StairTest {

    @DisplayName("Point의 방향이 오른쪽이면 오른쪽으로 이동한다.")
    @Test
    void right() {
        Point point = Point.first(true);
        Stair stair = Stair.of(0, point);

        Assertions.assertThat(stair.move()).isEqualTo(Position.of(1));
    }

    @DisplayName("Point의 방향이 왼쪽이면 왼쪽으로 이동한다.")
    @Test
    void left() {
        Point point = Point.of(true, false);
        Stair stair = Stair.of(2, point);

        Assertions.assertThat(stair.move()).isEqualTo(Position.of(1));
    }

    @DisplayName("Point의 방향이 정지면 해당자리에 그대로 있는다.")
    @Test
    void stop() {
        Point point = Point.of(false, false);
        Stair stair = Stair.of(2, point);

        Assertions.assertThat(stair.move()).isEqualTo(Position.of(2));
    }
}