package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeTest {

    @Test
    @DisplayName("사다리 연결 테스트")
    void connectSteps() {
        Bridge bridge = new Bridge();

        ConnectionStrategy alwaysTrueStrategy = new FakeConnectionStrategy(true);
        bridge.connectSteps(4, alwaysTrueStrategy);

        List<Connection> lines = bridge.getLines();

        assertTrue(lines.get(0).isConnect());
        assertFalse(lines.get(1).isConnect());
        assertTrue(lines.get(2).isConnect());
    }

    @Test
    @DisplayName("사다리 타기 테스트")
    public void move() {
        Bridge bridge = new Bridge();

        ConnectionStrategy alwaysTrueStrategy = new FakeConnectionStrategy(true);
        bridge.connectSteps(4, alwaysTrueStrategy);

        assertEquals(new Position(1), bridge.move(new Position(0)));
        assertEquals(new Position(0), bridge.move(new Position(1)));
    }

}
