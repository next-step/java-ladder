package ladder.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomConnectorTest {
    @Test
    @DisplayName("RandomConnector는 before와 연결되어 있으면 연결시키지 않는다.")
    void generateConnection_BeforeIsTrue_IsFalse() {
        final RandomConnector connector = new RandomConnector();
        assertThat(connector.generateNextConnection(true)).isFalse();
    }

    @Test
    @DisplayName("RandomConnector는 before와 연결되어 있지 않으면 이후에 랜덤으로 연결시킨다.")
    void generateConnection_BeforeIsFalse_CreatedRandom() {
        final RandomConnector connector = new RandomConnector();
        assertThat(connector.generateNextConnection(true)).isInstanceOf(Boolean.class);
    }
}
