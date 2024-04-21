package ladder.domain.ladder.line;

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
    @DisplayName("왼쪽으로 이동한다.")
    void Move_DirectionLeft() {
        final Connection connection = Connection.first(true).next(false);

        assertThat(connection.move(1))
                .isEqualTo(0);
    }

    @Test
    @DisplayName("오른쪽으로 이동한다.")
    void Move_DirectionRight() {
        final Connection connection = Connection.first(true);

        assertThat(connection.move(1))
                .isEqualTo(2);
    }

    @Test
    @DisplayName("아래쪽으로 이동한다.")
    void Move_DirectionDown() {
        final Connection connection = Connection.first(true).next(false).last();

        assertThat(connection.move(1))
                .isEqualTo(1);
    }
}
