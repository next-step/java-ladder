package nextstep.ladder.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DirectionTest {

    @DisplayName("Direction 객체 생성 테스트")
    @Test
    void init() {
        assertThat(Direction.of(TRUE, FALSE)).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @DisplayName("true 가 연속될 경우 오류가 발생한다.")
    @Test
    void init_invalid() {
        assertThatThrownBy(() -> Direction.of(TRUE, TRUE))
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("이전 좌표가 false 이면 다음 좌표는 true 가 될 수 있다.")
    @Test
    void next_true() {
        Direction next = Direction.of(TRUE, FALSE).next(TRUE);
        assertThat(next).isEqualTo(Direction.of(FALSE, TRUE));
    }

    @DisplayName("이전 좌표가 true 이면 다음 좌표는 false 다.")
    @Test
    void next_false() {
        Direction next = Direction.of(FALSE, TRUE).next(FALSE);
        assertThat(next).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @DisplayName("좌표의 시작점의 left 는 false 다.")
    @Test
    void first() {
        Direction first = Direction.first(TRUE);
        assertThat(first).isEqualTo(Direction.of(FALSE, TRUE));
    }

    @DisplayName("좌표의 끝점의 current 는 false 다.")
    @Test
    void last() {
        Direction last = Direction.first(TRUE).last();
        assertThat(last).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @DisplayName("좌표의 left 가 false 이고 current 가 true 이면 1을 리턴한다.")
    @Test
    void move_right() {
        assertThat(Direction.of(FALSE, TRUE).move()).isEqualTo(1);
    }

    @DisplayName("좌표의 left 가 true 이고 current 가 false 이면 -1을 리턴한다.")
    @Test
    void move_left() {
        assertThat(Direction.of(TRUE, FALSE).move()).isEqualTo(-1);
    }

    @DisplayName("좌표의 left 가 false 이고 current 가 false 이면 0을 리턴한다.")
    @Test
    void move_next() {
        assertThat(Direction.of(FALSE, FALSE).move()).isZero();
    }
}