package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DotTest {
    @Test
    void create() {
        Dot dot2 = new Dot(false);
        assertFalse(dot2.getValue());
    }

    @Test
    void getMoveStep_stop() {
        Dot dot2 = new Dot(false);
        int step = dot2.getMoveStep();
        assertThat(step).isEqualTo(0);
    }

    @Test
    void getMoveStep_move() {
        Dot dot2 = new Dot(true);
        int step = dot2.getMoveStep();
        assertThat(step).isEqualTo(1);
    }

    @Test
    void getMoveStepWithPreDot_back() {
        Dot dot2 = new Dot(false);
        int step = dot2.getMoveStepWithPreDot(true);
        assertThat(step).isEqualTo(-1);
    }

    @Test
    void getMoveStepWithPreDot_move() {
        Dot dot2 = new Dot(true);
        int step = dot2.getMoveStepWithPreDot(false);
        assertThat(step).isEqualTo(1);
    }

    @Test
    void getMoveStepWithPreDot_stop() {
        Dot dot2 = new Dot(false);
        int step = dot2.getMoveStepWithPreDot(false);
        assertThat(step).isEqualTo(0);
    }
}
