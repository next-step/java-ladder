package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DirectionTest {

    @DisplayName("Direction Exception Test - 양방향으로 갈수 없음")
    @Test
    public void directionExceptionTest() {
        assertThatThrownBy(() -> {
            Direction.of(true, true);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("왼쪽 이동 테스트")
    @Test
    public void moveLeftTest() {
        Direction direction = Direction.of(true, false);
        int move = direction.move(1);
        assertThat(move).isEqualTo(0);
    }

    @DisplayName("오른 이동 테스트")
    @Test
    public void moveRightTest() {
        Direction direction = Direction.of(false, true);
        int move = direction.move(1);
        assertThat(move).isEqualTo(2);
    }

    @DisplayName("재자리 이동 테스트")
    @Test
    public void moveNoneTest() {
        Direction direction = Direction.of(false, false);
        int move = direction.move(1);
        assertThat(move).isEqualTo(1);
    }
}
