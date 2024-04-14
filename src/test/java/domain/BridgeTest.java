package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeTest {

    @DisplayName("Bridge 유무를 확인한다.")
    @Test
    void test01() {
        Bridge bridge = new Bridge(true);
        assertThat(bridge.has()).isTrue();
    }

    @DisplayName("첫 번째 다리 (Bridge) 를 생성한다.")
    @Test
    void test02() {
        Bridge bridge = Bridge.first(true);
        assertThat(bridge.move()).isEqualTo(Direction.RIGHT);
    }

    @DisplayName("왼쪽으로 이동한다.")
    @Test
    void test03() {
        Bridge bridge = Bridge.first(true).next(false);
        assertThat(bridge.move()).isEqualTo(Direction.LEFT);
    }

    @DisplayName("오른쪽으로 이동한다.")
    @Test
    void test04() {
        Bridge bridge = Bridge.first(false).next(true);
        assertThat(bridge.move()).isEqualTo(Direction.RIGHT);
    }

    @DisplayName("패스한다.")
    @Test
    void test05() {
        Bridge bridge = Bridge.first(false).next(false);
        assertThat(bridge.move()).isEqualTo(Direction.PASS);
    }
}
