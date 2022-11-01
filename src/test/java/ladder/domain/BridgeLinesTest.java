package ladder.domain;

import ladder.exception.BridgeLinesDifferenceHeightException;
import ladder.exception.ContinuousBridgeLinesException;
import ladder.exception.InvalidBridgeLinesSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class BridgeLinesTest {

    @DisplayName("사다리 다리 라인 목록 생성")
    @Test
    void create() {
        assertDoesNotThrow(() -> {
            new BridgeLines(List.of(
                    new BridgeLine(List.of(true)),
                    new BridgeLine(List.of(false))
            ));
        });
    }

    @DisplayName("사다리 다리 라인 목록 생성 실패 - 외다리")
    @Test
    void invalid_single() {
        assertThatThrownBy(() -> new BridgeLines(List.of(
                new BridgeLine(List.of(true))
        ))).isInstanceOf(InvalidBridgeLinesSizeException.class);
    }

    @DisplayName("사다리 다리 라인 목록 생성 실패 - 다리 라인 높이 다름")
    @Test
    void invalid_differentHeight() {
        assertThatThrownBy(() -> new BridgeLines(List.of(
                new BridgeLine(List.of(true)),
                new BridgeLine(List.of(true, false))
        ))).isInstanceOf(BridgeLinesDifferenceHeightException.class);
    }

    @DisplayName("사다리 다리 라인 목록 생성 실패 - 다리 연결이 연속됨")
    @Test
    void invalid_continuousConnection() {
        assertThatThrownBy(() -> new BridgeLines(List.of(
                new BridgeLine(List.of(false, true, true)),
                new BridgeLine(List.of(true, true, false))
        ))).isInstanceOf(ContinuousBridgeLinesException.class);
    }
}
