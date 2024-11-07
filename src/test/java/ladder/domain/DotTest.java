package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DotTest {
    @Test
    void create() {
        Dot dot2 = Dot.firstDot(false);
        assertThat(dot2.getValue()).isFalse();
    }

    @Test
    void getMoveStep_stop() {
        Dot dot2 = Dot.firstDot(false);
        int step = dot2.getMoveStep();
        assertThat(step).isEqualTo(0);
    }

    @Test
    void getMoveStep_move() {
        Dot dot = Dot.firstDot(true);
        int step = dot.getMoveStep();
        assertThat(step).isEqualTo(1);
    }
    @Test
    void getMoveStep_back() {
        Dot dot1 = Dot.firstDot(true);
        Dot dot2 = dot1.nextDot();
        assertThat(dot2.getMoveStep()).isEqualTo(0);
    }

    @Test
    @DisplayName("다음Dot은 왼쪽Dot 값의 반대 값")
    void nextDot() {
        Dot dot1 = Dot.firstDot(false);
        Dot dot2 = dot1.nextDot();
        assertThat(dot2.getValue()).isTrue();
    }

    @Test
    @DisplayName("마지막 Dot 값은 항상 false")
    void lastDot() {
        Dot lastDot = Dot.lastDot(3, false);
        assertThat(lastDot.getValue()).isFalse();
        Dot lastDot2 = Dot.lastDot(3, true);
        assertThat(lastDot.getValue()).isFalse();
    }
}
