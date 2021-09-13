package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LadderTest {

    public static final int HEIGHT = 6;

    @Test
    @DisplayName("drawStrategy 에 따라 step 그리기")
    public void drawStepNoPreviousLadder() {
        Ladder ladder = new Ladder(HEIGHT);
        ladder.drawSteps(new OneByTwoDrawStrategy(), null);

        assertThat(ladder.hasStep(0)).isFalse();
        assertThat(ladder.hasStep(1)).isTrue();
    }

    @Test
    @DisplayName("drawStrategy 에서 그리라고 해도 이전 ladder 같은 위치에 이미 있으면 그리지 않음")
    public void hasStep() {
        Ladder previousLadder = new Ladder(HEIGHT);
        previousLadder.drawSteps(new OneByTwoDrawStrategy(), null);

        Ladder ladder = new Ladder(HEIGHT);
        ladder.drawSteps(new AllDrawStrategy(), previousLadder);

        assertThat(ladder.hasStep(0)).isTrue();
        assertThat(ladder.hasStep(1)).isFalse();
    }
}