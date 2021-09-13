package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LineTest {

    public static final int HEIGHT = 6;

    @Test
    @DisplayName("drawStrategy 에 따라 step 그리기")
    public void drawStepNoPreviousLadder() {
        Line line = new Line(HEIGHT);
        line.drawSteps(new OneByTwoDrawStrategy(), null);

        assertThat(line.hasStep(0)).isFalse();
        assertThat(line.hasStep(1)).isTrue();
    }

    @Test
    @DisplayName("drawStrategy 에서 그리라고 해도 이전 ladder 같은 위치에 이미 있으면 그리지 않음")
    public void hasStep() {
        Line previousLine = new Line(HEIGHT);
        previousLine.drawSteps(new OneByTwoDrawStrategy(), null);

        Line line = new Line(HEIGHT);
        line.drawSteps(new AllDrawStrategy(), previousLine);

        assertThat(line.hasStep(0)).isTrue();
        assertThat(line.hasStep(1)).isFalse();
    }
}