package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BridgeTest {

    @DisplayName("첫 번째 다리 (Bridge) 를 생성한다.")
    @Test
    void test01() {
        Bridge bridge = Bridge.firstOf(true);
        assertThat(bridge.move()).isEqualTo(Direction.RIGHT);
    }

    @DisplayName("왼쪽으로 이동한다.")
    @Test
    void test02() {
        Bridge bridge = Bridge.firstOf(true).next(false);
        assertThat(bridge.move()).isEqualTo(Direction.LEFT);
    }

    @DisplayName("오른쪽으로 이동한다.")
    @Test
    void test03() {
        Bridge bridge = Bridge.firstOf(false).next(true);
        assertThat(bridge.move()).isEqualTo(Direction.RIGHT);
    }

    @DisplayName("패스한다.")
    @Test
    void test04() {
        Bridge bridge = Bridge.firstOf(false).next(false);
        assertThat(bridge.move()).isEqualTo(Direction.PASS);
    }

    @DisplayName("다리를 연속해서 놓을 경우 예외가 발생한다.")
    @Test
    void test05() {
        assertThatThrownBy(() -> Bridge.firstOf(true).next(true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("다리를 연속해서 놓을 수 없습니다.");
    }

    @DisplayName("정적 팩터리 메서드를 통해 다음 Bridge 객체를 생성한다.")
    @Test
    void test06() {
        assertThat(Bridge.nextOf(Bridge.firstOf(true), false)).isNotNull();
    }

    @DisplayName("이동 방향을 확인한다.")
    @Test
    void test07() {
        assertThat(Bridge.firstOf(true).isMoveDirection(Direction.RIGHT)).isTrue();
    }
}
