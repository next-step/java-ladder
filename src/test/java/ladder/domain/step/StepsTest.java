package ladder.domain.step;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Collections.emptyList;
import static ladder.domain.step.StepTest.CROSSABLE_STEP;
import static ladder.domain.step.StepTest.UN_CROSSABLE_STEP;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StepsTest {
    @Test
    void Steps는_steps_없이_생성_할_수_없다() {
        assertThatThrownBy(
                () -> new Steps(null)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void lastIsCrossable은_마지막_step의_cross가능_여부를_반환한다() {
        assertAll(
                () -> assertTrue(new Steps(List.of(UN_CROSSABLE_STEP, CROSSABLE_STEP)).lastIsCrossable()),
                () -> assertFalse(new Steps(List.of(CROSSABLE_STEP, UN_CROSSABLE_STEP)).lastIsCrossable())
        );
    }

    @Test
    void lastIsCrossable은_step이_비어있는_경우_false를_반환한다() {
        assertAll(
                () -> assertFalse(new Steps(emptyList()).lastIsCrossable())
        );
    }

    @Test
    void extend는_연속으로_건널수_있는_step을_추가_할_경우_예외를_발생시킨다() {
        Steps steps = new Steps(List.of(CROSSABLE_STEP));

        assertThatThrownBy(
                () -> steps.extend(CROSSABLE_STEP)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void extend는_step이_추가된_Steps를_반환한다() {
        Steps steps = new Steps(List.of(CROSSABLE_STEP));

        Steps newSteps = steps.extend(UN_CROSSABLE_STEP);

        assertAll(
                () -> assertEquals(steps.size() + 1, newSteps.size()),
                () -> assertEquals(UN_CROSSABLE_STEP, newSteps.getSteps().get(newSteps.size() - 1))
        );
    }
}
