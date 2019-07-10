package ladder.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomConnectorTest {
    @Test
    @DisplayName("RandomConnector는 현재 점이 오른쪽과 연결되어 있으면 다음 연결점을 LEFT로 연결시킨다.")
    void generateConnection_BeforeIsTrue_IsFalse() {
        final RandomConnector connector = new RandomConnector();
        assertThat(connector.generateNextConnection(Direction.RIGHT)).isEqualByComparingTo(Direction.LEFT);
    }

    @Test
    @DisplayName("RandomConnector는 현재 점이 다음 점과 연결되어 있지 않으면 이후에 RIGHT, DOWN중 랜덤으로 연결시킨다.")
    void generateConnection_BeforeIsFalse_CreatedRandom() {
        final RandomConnector connector = new RandomConnector();
        assertThat(connector.generateNextConnection(Direction.LEFT)).isExactlyInstanceOf(Direction.class)
                                                                    .isNotEqualTo(Direction.LEFT);
    }
}
