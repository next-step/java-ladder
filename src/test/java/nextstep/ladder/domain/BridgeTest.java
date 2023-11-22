package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static nextstep.ladder.exception.ExceptionMessage.*;
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
            .hasMessage(CAN_NOT_TRUE_STRAIGHT.message());
    }

    @DisplayName("인자로 받은 위치의 다리가 이동 가능한지 확인한다.")
    @Test
    void isMovable() {
        // given
        Bridges bridges = new Bridges(List.of(true, false, true));

        // when
        int xAxis = 1;

        // then
        assertThat(bridges.isMovable(xAxis)).isFalse();
    }

    @DisplayName("인자로 받은 위치 값이 인덱스 범위를 벗어나면 예외를 발생시킨다.")
    @Test
    void isMovableWhenOutOfRange() {
        // given
        Bridges bridges = new Bridges(List.of(true, false, true));

        // when & then
        assertThatThrownBy(() -> bridges.isMovable(3)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(OUT_OF_INDEX.message());
    }
}
