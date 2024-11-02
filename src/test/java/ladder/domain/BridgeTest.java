package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BridgeTest {

    @Test
    @DisplayName("사다리 연결 테스트")
    void connectSteps() {
        Bridge bridge = new Bridge();

        ConnectionStrategy alwaysTrueStrategy = new FakeConnectionStrategy(true);
        bridge.connectSteps(4, alwaysTrueStrategy);

        assertEquals(true, bridge.getConnections().get(0));
        assertEquals(false, bridge.getConnections().get(1));
        assertEquals(true, bridge.getConnections().get(2));
    }

    @Test
    @DisplayName("사다리 타기 테스트")
    public void move() {
        Bridge bridge = new Bridge();

        ConnectionStrategy alwaysTrueStrategy = new FakeConnectionStrategy(true);
        bridge.connectSteps(4, alwaysTrueStrategy);

        assertEquals(1, bridge.move(0));
        assertEquals(0, bridge.move(1));
    }

}
