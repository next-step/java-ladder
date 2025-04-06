package nextstep.ladder.module;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    @DisplayName("Line의 시작이 0 이 아니면 에러")
    void givenPointXsWithStartNotZero_whenCreateLine_thenThrowException() {
        PointX pointX1 = new PointX(1, new Ladder());
        PointX pointX2 = new PointX(2, new Ladder());
        PointX pointX3 = new PointX(3, new Ladder());

        assertThatThrownBy(() -> new Line(Arrays.asList(pointX1, pointX2, pointX3)))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("Line의 시작과 끝은 0과 (n-1)이어야 합니다.");
    }

    @Test
    @DisplayName("Line의 끝이 (n-1)이 아니면 에러")
    void givenPointXsWithEndNotNMinusOne_whenCreateLine_thenThrowException() {
        PointX pointX1 = new PointX(0, new Ladder());
        PointX pointX2 = new PointX(1, new Ladder());
        PointX pointX3 = new PointX(3, new Ladder());

        assertThatThrownBy(() -> new Line(Arrays.asList(pointX1, pointX2, pointX3)))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("Line의 시작과 끝은 0과 (n-1)이어야 합니다.");
    }

    @Test
    @DisplayName("Line의 시작과 끝이 0과 (n-1)이면 통과")
    void givenPointXsWithStartAndEndZeroAndNMinusOne_whenCreateLine_thenPass() {
        PointX pointX1 = new PointX(0, new Ladder());
        PointX pointX2 = new PointX(1, new Ladder());
        PointX pointX3 = new PointX(2, new Ladder());

        assertThat(new Line(Arrays.asList(pointX1, pointX2, pointX3)).value())
            .containsExactly(pointX1, pointX2, pointX3);
    }
}
