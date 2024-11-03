package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PositionTest {

    @Test
    void 위치_저장_테스트() {
        Position position = new Position(1);

        assertThat(position).isEqualTo(new Position("1"));
    }

    @Test
    void 위치_저장_실패_테스트() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("위치는 0보다 작을 수 없습니다.");
    }

}


