package ladder.domain.step;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StepTest {
    static final Step CROSSABLE_STEP = new Step(() -> true);
    static final Step UN_CROSSABLE_STEP = new Step(() -> false);

    @Test
    void Step은_CrossableStrategy없이_생성_할_경우_예외를_발생_시킨다() {
        assertThatThrownBy(
                () -> new Step(null)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isCrossable은_cross가능_여부를_반환한다() {
        assertAll(
                () -> assertTrue(CROSSABLE_STEP.isCrossable()),
                () -> assertFalse(UN_CROSSABLE_STEP.isCrossable())
        );
    }
}
