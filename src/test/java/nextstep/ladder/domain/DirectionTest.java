package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {

    @Test
    @DisplayName("getDirection 메소드를 통한 오른쪽 테스트")
    void right() {
        assertThat(Direction.getDirection(false, true)).isEqualTo(Direction.RIGHT);
    }

    @Test
    @DisplayName("getDirection 메소드를 통한 왼쪽 테스트")
    void left() {
        assertThat(Direction.getDirection(true,false)).isEqualTo(Direction.LEFT);
    }

    @Test
    @DisplayName("getDirection 메소드를 통한 pass 테스트")
    void pass() {
        assertThat(Direction.getDirection(false,false)).isEqualTo(Direction.PASS);
    }

}
