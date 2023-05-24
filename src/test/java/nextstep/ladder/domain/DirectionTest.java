package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class DirectionTest {

    @DisplayName("이전값이 true이고 현재 값이 false이면 -1을 반환한다.")
    @Test
    void name() {
        Direction direction = new Direction(true, false);
        assertThat(direction.move()).isEqualTo(-1);

    }
    @DisplayName("이전값이 false 현재 값이 true이면 +1을 반환한다.")
    @Test
    void name1() {
        Direction direction = new Direction(false, true);
        assertThat(direction.move()).isEqualTo(1);
    }

    @DisplayName("이전값이 false이고 현재 값이 false이면 0를 반환한다.")
    @Test
    void name2() {
        Direction direction = new Direction(false, false);
        assertThat(direction.move()).isEqualTo(0);
    }

    @DisplayName("이전값이 true이고 현재 값이 true이면 예외를 발생한다.")
    @Test
    void name3() {
        assertThatThrownBy(() -> new Direction(true, true))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("첫 번째 index일 경우 current 값이 false이면 0을 반환한다. ")
    @Test
    void name4() {
        Direction direction = Direction.of(false);
        assertThat(direction.move()).isEqualTo(1);
    }

    @DisplayName("첫 번째 index일 경우 current 값이 true이면 1을 반환한다. ")
    @Test
    void name4() {
        Direction direction = Direction.of(true);
        assertThat(direction.move()).isEqualTo(1);
    }

    @DisplayName("마지막 index일 경우 previous 값이 false면 0을 반환한다.")
    @Test
    void name5() {
        Direction direction = Direction.of(false).last();
        assertThat(direction.move()).isEqualTo(0);
    }

    @DisplayName("마지막 index일 경우 previous 값이 true면 1을 반환한다.")
    @Test
    void name6() {
        Direction direction = Direction.of(true).last();
        assertThat(direction.move()).isEqualTo(1);
    }
}
