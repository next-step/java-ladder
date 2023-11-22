package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BridgeTest {

    @DisplayName("사다리의 x축인 다리를 생성한다.")
    @Test
    void createBridge() {
        assertThat(new Bridges(List.of(true, false))).isEqualTo(new Bridges(List.of(true, false)));
    }

    @DisplayName("사다리의 x축인 다리가 연속으로 존재(true)하면 예외를 발생시킨다.")
    @Test
    void createBridgesWhenTruInARow() {
        assertThatThrownBy(() -> new Bridges(List.of(true, true, false))).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("사다리의 다리는 연속으로 존재할 수 없습니다.");
    }

    @DisplayName("사다리 x축의 특정 위치의 다리가 이동 가능한지 확인한다.")
    @Test
    void isMovable() {
        // given
        Bridges bridges = new Bridges(List.of(true, false, true));

        // when
        int position = 1;

        // then
        assertThat(bridges.isMovable(position)).isFalse();
    }
}
