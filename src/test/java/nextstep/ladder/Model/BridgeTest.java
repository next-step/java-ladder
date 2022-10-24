package nextstep.ladder.Model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BridgeTest {

    @Test
    void lastConstructorTest() {
        Bridge bridge = Bridge.first(() -> true).next(() -> false).last();
        assertThat(bridge.move()).isEqualTo(Direction.PASS);
    }

    @Test
    void firstConstructorTest() {
        Bridge bridge = Bridge.first(() -> true);
        assertThat(bridge.move()).isEqualTo(Direction.RIGHT);
    }


    @Test
    void rightMoveTest() {
        Bridge bridge = Bridge.first(() -> false).next(() -> true);
        assertThat(bridge.move()).isEqualTo(Direction.RIGHT);
    }

    @Test
    void leftMoveTest() {
        Bridge bridge = Bridge.first(() -> true).next(() -> false);
        assertThat(bridge.move()).isEqualTo(Direction.LEFT);
    }

    @Test
    void passMoveTest() {
        Bridge bridge = Bridge.first(() -> false);
        assertThat(bridge.move()).isEqualTo(Direction.PASS);
    }
}