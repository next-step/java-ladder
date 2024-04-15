package ladder.domain.ladder.line;

import static ladder.domain.ladder.line.Direction.DOWN;
import static ladder.domain.ladder.line.Direction.LEFT;
import static ladder.domain.ladder.line.Direction.RIGHT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConnectionTest {

    @Test
    @DisplayName("사다리 라인의 연결을 생성한다.")
    void Connection() {
        assertThat(Connection.first(true))
                .isEqualTo(Connection.first(true));
    }

    @Test
    @DisplayName("왼쪽과 오른쪽 모두 연결된 경우 예외를 던진다.")
    void Connection_LeftAndRightConnected_Exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Connection.first(true).next(true));
    }

    @Test
    @DisplayName("왼쪽으로 이동 가능하다면, 왼쪽 방향을 반환한다.")
    void Move_DirectionLeft() {
        final Connection connection = Connection.first(true).next(false);

        assertThat(connection.move())
                .isEqualTo(LEFT);
    }

    @Test
    @DisplayName("오른쪽으로 이동 가능하다면, 오른쪽 방향을 반환한다.")
    void Move_DirectionRight() {
        final Connection connection = Connection.first(true);

        assertThat(connection.move())
                .isEqualTo(RIGHT);
    }

    @Test
    @DisplayName("왼쪽 오른쪽 모두 이동 가능하지 않다면, 아래 방향을 반환한다.")
    void Move_DirectionDown() {
        final Connection connection = Connection.first(true).next(false).last();

        assertThat(connection.move())
                .isEqualTo(DOWN);
    }
}
