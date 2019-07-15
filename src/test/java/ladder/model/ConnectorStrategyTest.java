package ladder.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConnectorStrategyTest {
    @Test
    @DisplayName("ConnectorStrategy는 Point의 연결 정보를 생성한다.")
    void generateConnection() {
        final ConnectorStrategy connector = () -> false;
        assertThat(connector.isConnectedToRight()).isFalse();
    }
}