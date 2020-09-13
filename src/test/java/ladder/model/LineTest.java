package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class LineTest {

    @Test
    @DisplayName("Line 생성 테스트")
    public void createLine() {
        // given
        LadderGenerateStrategy condition = () -> true;
        List<Step> expectedSteps = Arrays.asList(
                new Step(0, new Direction(false, true)),
                new Step(1, new Direction(true, false)),
                new Step(2, new Direction(false, true)),
                new Step(3, new Direction(true, false)));

        // when
        Line line = new Line(4, condition);

        // then
        assertThat(line.getSteps()).isEqualTo(expectedSteps);
    }

    @Test
    @DisplayName("사다리 타기 테스트 : 다리가 있는 경우")
    public void movePoint_has_step() {
        // given
        LadderGenerateStrategy condition = () -> true;
        Line line = new Line(2, condition);

        // when
        int result = line.movePoint(0);

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("사다리 타기 테스트 : 다리가 없는 경우")
    public void movePoint_dose_not_have_step() {
        // given
        LadderGenerateStrategy condition = () -> false;
        Line line = new Line(2, condition);

        // when
        int result = line.movePoint(1);

        // then
        assertThat(result).isEqualTo(1);
    }

}
