package laddergame.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {
    @DisplayName("처음 시작 위치는 자신의 열번호와 높이 1로 구성된다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void startPosition(int column) {
        Position position = new Position(column);

        assertThat(position.getHeight()).isEqualTo(1);
        assertThat(position.getColumn()).isEqualTo(column);
    }
}