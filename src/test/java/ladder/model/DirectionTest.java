package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class DirectionTest {

    @Test
    @DisplayName("방향 생성하기 : invalid")
    public void create_direction_invalid() {
        assertThatThrownBy(() -> new Direction(true, true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("방향은 왼쪽, 오른쪽 중 하나만 가질 수 있습니다.");
    }

    @Test
    @DisplayName("왼쪽으로 움직이기")
    public void move_left() {
        // given
        Direction left = new Direction(true, false);

        // when
        int moveResult = left.move();

        // then
        assertThat(moveResult).isEqualTo(1);

    }

    @Test
    @DisplayName("오른쪽으로 움직이기")
    public void move_right() {
        // given
        Direction right = new Direction(false, true);

        // when
        int moveResult = right.move();

        // then
        assertThat(moveResult).isEqualTo(1);

    }

    @Test
    @DisplayName("다음 방향 생성 : 오른쪽 방향이 있을 때, 왼쪽 방향으로 자동 생성")
    public void next_when_has_right() {
        // given
        Direction left = new Direction(false, true);

        // when
        Direction result = left.next(true);

        // then
        assertThat(result).isEqualTo(new Direction(true, false));
    }

    @Test
    @DisplayName("다음 방향 생성 : 오른쪽 방향이 없을 때, 입력 값에 따라 오른쪽 방향 생성")
    public void next_when_does_not_has_right() {
        // given
        Direction none = new Direction(false, false);

        // when
        Direction result = none.next(true);

        // then
        assertThat(result).isEqualTo(new Direction(false, true));
    }

}
