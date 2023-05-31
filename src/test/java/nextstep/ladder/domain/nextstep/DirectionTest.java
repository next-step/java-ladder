package nextstep.ladder.domain.nextstep;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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

    @DisplayName("연속으로 true 값 설정이 불가하게 current 값이 false로 설정된다.")
    @Test
    void name3() {
        assertThat(new Direction(true, true)).isEqualTo(new Direction(true, false));
    }

    @DisplayName("첫 번째 index일 경우 current 값이 false이면 0을 반환한다. ")
    @Test
    void name4() {
        Direction direction = Direction.first(false);
        assertThat(direction.move()).isEqualTo(0);
    }

    @DisplayName("첫 번째 index일 경우 current 값이 true이면 1을 반환한다. ")
    @Test
    void name7() {
        Direction direction = Direction.first(true);
        assertThat(direction.move()).isEqualTo(1);
    }

    @DisplayName("마지막 index일 경우 previous 값이 false면 0을 반환한다.")
    @Test
    void name5() {
        Direction direction = Direction.first(false).last();
        assertThat(direction.move()).isEqualTo(0);
    }

    @DisplayName("마지막 index일 경우 previous 값이 true면 -1을 반환한다.")
    @Test
    void name6() {
        Direction direction = Direction.first(true).last();
        assertThat(direction.move()).isEqualTo(-1);
    }
}
