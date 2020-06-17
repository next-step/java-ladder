package laddergame.domain.ladder;

import laddergame.domain.player.Position;
import laddergame.domain.vo.Column;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class BridgeTest {

    @DisplayName("true 또는 false로 Bridge 생성시 연결여부를 결정한다.")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void newBridge(boolean isConnect) {
        Bridge bridge = new Bridge(isConnect, 1);

        assertThat(bridge.isConnected()).isEqualTo(isConnect);
    }

    @DisplayName("두 인접 Bridge가 연속으로 연결되어있는지 확인")
    @ParameterizedTest
    @CsvSource({"true, true, true", "false, true, false", "true, false, false"})
    void isContinuousBridge(boolean beforeConnection, boolean nextConnection, boolean result) {
        Bridge before = new Bridge(beforeConnection, 1);
        Bridge next = new Bridge(nextConnection, 2);

        assertThat(Bridge.isContinuousBridge(before, next)).isEqualTo(result);
    }

    @DisplayName("두 Bridge가 인접 Bridge가 아니라면 연결 여부에 상관없이 false 반환")
    @ParameterizedTest
    @CsvSource({"true, true", "true, false", "false, true", "false, false"})
    void isContinuousBridgeNotNext(boolean beforeConnection, boolean nextConnection) {
        Bridge before = new Bridge(beforeConnection, 1);
        Bridge next = new Bridge(nextConnection, 3);

        assertThat(Bridge.isContinuousBridge(before, next)).isFalse();
    }

    @DisplayName("인자로 받은 Column이 자신이 연결되어있는지 반환")
    @ParameterizedTest
    @CsvSource({"1, true", "4, false"})
    void isBridgeColumn(int column, boolean expectedResult) {
        Bridge bridge = new Bridge(true, 1);

        assertThat(bridge.isBridgeColumn(new Column(column))).isEqualTo(expectedResult);
    }

    @DisplayName("Position의 위치가 Bridge의 왼쪽이라면 오른쪽으로 움직인다.")
    @Test
    void positionMoveRight() {
        Bridge bridge = new Bridge(true, 1);
        Position position = new Position(1, 1);

        Position afterMove = bridge.movePositionColumn(position);

        assertThat(afterMove).isEqualTo(new Position(2, 1));
    }

    @DisplayName("Position의 위치가 Bridge의 오른쪽이라면 왼쪽으로 움직인다.")
    @Test
    void positionMoveLeft() {
        Bridge bridge = new Bridge(true, 1);
        Position position = new Position(2, 1);

        Position afterMove = bridge.movePositionColumn(position);

        assertThat(afterMove).isEqualTo(new Position(1, 1));
    }

    @DisplayName("Bridge가 연결되어있지 않다면 움직이지않는다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void positionNotMove(int column) {
        Bridge bridge = new Bridge(false, 1);
        Position position = new Position(column, 1);

        Position afterMove = bridge.movePositionColumn(position);

        assertThat(afterMove).isEqualTo(new Position(column, 1));
    }
}
