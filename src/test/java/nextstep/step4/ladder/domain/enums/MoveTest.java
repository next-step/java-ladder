package nextstep.step4.ladder.domain.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-07-07 22:54
 */
class MoveTest {

    @DisplayName("left[true] / right[false] -1 반환")
    @Test
    void move_left() {
        assertThat(Move.getDirection(true, false)).isEqualTo(-1);
    }

    @DisplayName("left[false] / right[true] 1 반환")
    @Test
    void move_right() {
        assertThat(Move.getDirection(false, true)).isEqualTo(1);
    }

    @DisplayName("left[false] / right[fasle] 0 반환")
    @Test
    void move_next_line() {
        assertThat(Move.getDirection(false, false)).isEqualTo(0);
    }
}