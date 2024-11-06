package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class DotTest {
    @Test
    void create() {
        Dot dot2 = new Dot(false,false);
        assertThat(dot2.getValue()).isFalse();
    }

    @Test
    void getMoveStep_stop() {
        Dot dot2 = new Dot(false,false);
        int step = dot2.getMoveStep();
        assertThat(step).isEqualTo(0);
    }

    @Test
    void getMoveStep_move() {
        Dot dot2 = new Dot(false,true);
        int step = dot2.getMoveStep();
        assertThat(step).isEqualTo(1);
    }

    @Test
    void getMoveDirection_back() {
        Dot dot2 = new Dot(true,false);
        int step = dot2.getMoveStep();
        assertThat(step).isEqualTo(-1);
    }

    @Test
    void getMoveStepWithPreDot_move() {
        Dot dot2 = new Dot(false, true);
        int step = dot2.getMoveStep();
        assertThat(step).isEqualTo(1);
    }

    @Test
    void getMoveStepWithPreDot_stop() {
        Dot dot2 = new Dot(false,false);
        int step = dot2.getMoveStep();
        assertThat(step).isEqualTo(0);
    }
}
