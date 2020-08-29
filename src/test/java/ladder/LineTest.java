package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class LineTest {

    @Test
    @DisplayName("Line 생성 테스트")
    public void createLine() {
        // given
        LadderGenerateStrategy condition = () -> true;
        Line expected = new Line(Arrays.asList(true, false, true, false));

        // when
        Line line = new Line(4, condition);

        // then
        assertThat(line).isEqualTo(expected);
    }

    @Test
    @DisplayName("Line 생성 실패 테스트")
    public void createLine_fail() {
        // given
        List<Boolean> invalidInput = Arrays.asList(true, true, true, false);

        // when
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Line(invalidInput));
    }

    @Test
    @DisplayName("두 위치 사이에 다리가 있는 경우")
    public void canSwapLocation() {
        // given
        Line line = new Line(Arrays.asList(true, false));

        // when
        boolean result = line.hasStepBetween(0, 1);

        // then
        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("두 위치 사이에 다리가 없는 경우")
    public void canSwapLocation_no_step() {
        // given
        Line line = new Line(Arrays.asList(true, false));

        // when
        boolean result = line.hasStepBetween(1, 2);

        // then
        assertThat(result).isEqualTo(false);
    }

}