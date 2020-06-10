package laddergame.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeTypeTest {

    @DisplayName("boolean 값으로 맞는 BridgeType을 가져온다.")
    @ParameterizedTest
    @CsvSource({"true, CONNECTED", "false, DISCONNECTED"})
    void findType(boolean isConnected, BridgeType bridgeType) {
        assertThat(BridgeType.findType(isConnected)).isEqualTo(bridgeType);
    }
}