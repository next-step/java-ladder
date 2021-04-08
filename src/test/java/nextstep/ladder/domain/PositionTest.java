package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PositionTest {

    @DisplayName("Position 생성 테스트")
    @Test
    void create_생성테스트() {
        // given
        Position position = Position.valueOf(0);
        // when
        Position expected = Position.valueOf(0);
        // then
        assertThat(position).isEqualTo(expected);
    }

    @DisplayName("Position 이동 예외 테스트")
    @Test
    void move_이동테스트() {
        Position position = Position.valueOf(0);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(position::left);
    }

    @DisplayName("Position right 이동 테스트")
    @Test
    void move_right_이동테스트() {
        // given
        Position position = Position.valueOf(1);
        // when
        Position rightMovedPosition = position.right();
        Position expected = Position.valueOf(2);
        // then
        assertThat(rightMovedPosition).isEqualTo(expected);
    }

    @DisplayName("Position left 이동 테스트")
    @Test
    void move_left_이동테스트() {
        // given
        Position position = Position.valueOf(1);
        // when
        Position left = position.left();
        Position expected = Position.valueOf(0);
        // then
        assertThat(left).isEqualTo(expected);
    }
}
