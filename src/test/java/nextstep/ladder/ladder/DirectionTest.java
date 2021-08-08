package nextstep.ladder.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DirectionTest {

    @DisplayName("Direction 객체 생성테스트")
    @Test
    void init() {
        assertThat(Direction.of(true, false)).isEqualTo(Direction.of(true, false));
    }

    @DisplayName("좌표값에 true 가 연속으로 오는 경우 에러가 발생한다.")
    @Test
    void init_invalid() {
        assertThatThrownBy(() -> Direction.of(TRUE, TRUE))
                .isInstanceOf(IllegalStateException.class);

    }

    @DisplayName("첫번째 좌표가 true 인 경우 다음 좌표는 false 가 된다.")
    @Test
    void next_random_true() {
        Direction next = Direction.first(TRUE).next();
        assertThat(next).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @DisplayName("이전 좌표가 false 인 경우 현재 좌표는 true 가 될 수 있다.")
    @Test
    void next_true() {
        Direction next = Direction.of(TRUE, FALSE).next(TRUE);
        assertThat(next).isEqualTo(Direction.of(FALSE, TRUE));
    }

    @DisplayName("이전 좌표가 true 인 경우 현재 좌표는 false 여야 한다.")
    @Test
    void next_false() {
        Direction next = Direction.of(FALSE, TRUE).next(FALSE);
        assertThat(next).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @DisplayName("Direction 의 처음 좌표는 false 여야 한다.")
    @Test
    void first() {
        Direction first = Direction.first(TRUE);
        assertThat(first.isLeft()).isFalse();
    }

    @DisplayName("Direction 의 마지막 좌표는 false 여야 한다.")
    @Test
    void last() {
        Direction last = Direction.first(TRUE).last();
        assertThat(last.isRight()).isFalse();
    }
}
