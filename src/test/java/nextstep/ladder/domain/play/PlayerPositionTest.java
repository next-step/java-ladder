package nextstep.ladder.domain.play;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PlayerPositionTest {

    @DisplayName("Position으로 PlayerPosition을 만든다")
    @Test
    void should_make_player() {
        //arrange, act, assert
        assertThat(PlayerPosition.of(0)).isInstanceOf(PlayerPosition.class);
    }

    @DisplayName("position이 0보다 작으면 IllegalArgumentException이 발생한다")
    @Test
    void should_throw_exception_when_position_below_0() {
        assertThatIllegalArgumentException().isThrownBy(() -> PlayerPosition.of(-1));
    }

    @DisplayName("PlayerPosition은 value를 반환한다")
    @Test
    void should_return_value() {
        //arrange, act, assert
        assertThat(PlayerPosition.of(0).getValue()).isEqualTo(0);
    }

    @DisplayName("PlayerPosition을 moveRight하면 position + 1한 PlayerPosition을 반환한다")
    @Test
    void should_return_move_right_position() {
        //arrange
        PlayerPosition position = PlayerPosition.of(0);

        //act
        PlayerPosition expectedPosition = position.moveRight();

        //assert
        assertThat(expectedPosition).isEqualTo(PlayerPosition.of(1));
    }

    @DisplayName("PlayerPosition을 moveLeft하면 position - 1한 PlayerPosition을 반환한다")
    @Test
    void should_return_move_left_position() {
        //arrange
        PlayerPosition position = PlayerPosition.of(1);

        //act
        PlayerPosition expectedPosition = position.moveLeft();

        //assert
        assertThat(expectedPosition).isEqualTo(PlayerPosition.of(0));
    }

}