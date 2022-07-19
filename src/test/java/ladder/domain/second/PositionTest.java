package ladder.domain.second;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @DisplayName("첫번째 위치에서 오른쪽 선이 있을 경우 오른쪽으로 위치를 움직임")
    @Test
    void first() {
        Position position = Position.first(true);
        assertThat(position.move()).isEqualTo(1);
    }

    @DisplayName("두번째 위치에서 왼쪽 선이 있을 경우 왼쪽으로 위치를 움직임")
    @Test
    void next() {
        Position position = Position.first(true).next(false);
        assertThat(position.move()).isEqualTo(0);
    }

    @DisplayName("마지막 위치에서 왼쪽에 선이 없을 경우 위치 그대로 아래로 이동")
    @Test
    void last() {
        Position position = Position.first(true).next(false).last();
        assertThat(position.move()).isEqualTo(2);
    }
}