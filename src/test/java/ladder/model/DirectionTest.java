package ladder.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DirectionTest {

    @Test
    public void create_direction_invalid() {
        assertThatThrownBy(() -> new Direction(true, true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("방향은 왼쪽, 오른쪽 중 하나만 가질 수 있습니다.");
    }

    @Test
    public void move_left() {
        // given
        Direction left = new Direction(true, false);

        // when
        int moveResult = left.move();

        // then
        assertThat(moveResult).isEqualTo(1);

    }

    @Test
    public void move_right() {
        // given
        Direction left = new Direction(false, false);

        // when
        int moveResult = left.move();

        // then
        assertThat(moveResult).isEqualTo(1);

    }

}
