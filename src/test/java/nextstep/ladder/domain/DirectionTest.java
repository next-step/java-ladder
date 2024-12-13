package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {

    @Test
    @DisplayName("getDirection 메소드를 통한 오른쪽 테스트")
    void right() {
        assertThat(Direction.of(false, true)).isEqualTo(Direction.RIGHT);
    }

    @Test
    @DisplayName("getDirection 메소드를 통한 왼쪽 테스트")
    void left() {
        assertThat(Direction.of(true, false)).isEqualTo(Direction.LEFT);
    }

    @Test
    @DisplayName("getDirection 메소드를 통한 pass 테스트")
    void pass() {
        assertThat(Direction.of(false, false)).isEqualTo(Direction.PASS);
    }

    @Test
    @DisplayName("방향에 따른 x위치를 이동시킴")
    void addMoveX() {
        assertThat(Direction.PASS.moveX(0)).isEqualTo(0);
        assertThat(Direction.LEFT.moveX(1)).isEqualTo(0);
        assertThat(Direction.RIGHT.moveX(1)).isEqualTo(2);
    }

    @Test
    @DisplayName("방향 상관없이 y위치를 이동시킴")
    void addMoveY() {
        assertThat(Direction.PASS.moveY(0)).isEqualTo(1);
        assertThat(Direction.LEFT.moveY(1)).isEqualTo(2);
        assertThat(Direction.RIGHT.moveY(2)).isEqualTo(3);
    }

}
