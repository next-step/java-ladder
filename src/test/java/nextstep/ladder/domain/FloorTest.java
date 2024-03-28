package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FloorTest {

    @DisplayName("층수를 반환 할 수 있다.")
    @Test
    void getFloor() {
        // given
        Floor floor = Floor.of(3);

        // then
        assertThat(floor.getFloor()).isEqualTo(3);
    }

    @DisplayName("층수는 1보다 낮을 수 없다. 1보다 층수가 낮으면 IllegalArgumentException을 던진다.")
    @Test
    void throwIllegalArgumentExceptionWhenFloorIsLessThan1() {
        // then
        assertThrows(IllegalArgumentException.class, () -> Floor.of(0));
        assertThrows(IllegalArgumentException.class, () -> Floor.of(-1));
    }
}
