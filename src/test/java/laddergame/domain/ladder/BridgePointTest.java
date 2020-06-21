package laddergame.domain.ladder;

import laddergame.domain.vo.Column;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BridgePointTest {

    @DisplayName("다리 연결 column이 1보다 작으면 IllegalArgumentException")
    @Test
    void validateBridgePoint() {
        int left = 0;

        assertThatThrownBy(() -> new BridgePoint(left))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("열 번호는 1보다 작을 수 없습니다. - " + left);
    }

    @DisplayName("인자로 받은 column 값이 자신의 left 또는 right 와 같은지 반환")
    @ParameterizedTest
    @CsvSource({"1, true", "2, true", "3, false"})
    void isBridgeColumn(int expectColumn, boolean result) {
        BridgePoint bridgePoint = new BridgePoint(1);

        assertThat(bridgePoint.isBridgeColumn(new Column(expectColumn))).isEqualTo(result);
    }
}