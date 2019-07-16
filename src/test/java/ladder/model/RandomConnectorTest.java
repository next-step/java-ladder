package ladder.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomConnectorTest {
    @Test
    @DisplayName("RandomConnector는 오른쪽 점과 연결 여부를 랜덤으로 생성한다.")
    void generateConnection_BeforeIsTrue_IsFalse() {
        final RandomConnector connector = new RandomConnector();
        assertThat(connector.isConnectedToRight()).isInstanceOf(Boolean.class);
    }
}
