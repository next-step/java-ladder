package nextstep.refactoring;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

// 두개의 상태값을 가진다. (왼, 오른쪽 이동가능여부)
class SpotTest {

    @Test
    void createLeftFalseRightTrue() {
        Spot spot = new Spot(false, true);
        assertThat(spot).isNotNull();
    }

    @Test
    void createAllTrueFailed() {
        assertThatThrownBy(() -> new Spot(true, true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("올바르지 않은 상태값입니다.");
    }

    @Test
    void right() {
        Spot spot = new Spot(false, true);
        assertThat(spot.move()).isEqualTo(Direction.RIGHT);
    }

    @Test
    void left() {
        Spot spot = new Spot(true, false);
        assertThat(spot.move()).isEqualTo(Direction.LEFT);
    }

    @Test
    void pass() {
        Spot spot = new Spot(false, false);
        assertThat(spot.move()).isEqualTo(Direction.PASS);
    }

    @Test
    void first() {
        Spot spot = Spot.first(true);
        Spot result = new Spot(false, true);

        assertThat(spot).isEqualTo(result);
    }

    @Test
    void last() {
        Spot spot = Spot.first(true);
        Spot last = spot.last();
        Spot result = new Spot(true, false);

        assertThat(last).isEqualTo(result);
    }

}