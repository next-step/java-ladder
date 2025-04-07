package nextstep.ladder.module;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

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
        PointX pointX1 = new PointX(0);
        PointX pointX2 = new PointX(1);
        PointX pointX3 = new PointX(2);

        assertThat(new Line(Arrays.asList(pointX1, pointX2, pointX3)).points())
            .containsExactly(pointX1, pointX2, pointX3);
    }

    @Test
    @DisplayName("Line의 시작에는 사다리가 없어야함")
    void givenLineWithLadderAtStart_whenCreateLine_thenThrowException() {
        PointX pointX1 = new PointX(0, new Ladder(true));
        PointX pointX2 = new PointX(1);
        PointX pointX3 = new PointX(2);

        assertThatThrownBy(() -> new Line(Arrays.asList(pointX1, pointX2, pointX3)))

            .isInstanceOf(IllegalArgumentException.class).hasMessage("Line의 시작은 사다리가 없어야 합니다.");
    }

    @Test
    @DisplayName("Line에서 연속된 사다리가 있으면 안됨")
    void givenLineWithConsecutiveLadders_whenCreateLine_thenThrowException() {
        PointX pointX1 = new PointX(0);
        PointX pointX2 = new PointX(1, new Ladder(true));
        PointX pointX3 = new PointX(2, new Ladder(true ));
        PointX pointX4 = new PointX(3);

        assertThatThrownBy(() -> new Line(Arrays.asList(pointX1, pointX2, pointX3, pointX4)))
            .isInstanceOf(IllegalArgumentException.class).hasMessage("Line에서 연속된 사다리가 있으면 안됩니다.");
    }

    @Test
    @DisplayName("Line의 크기가 2보다 작으면 에러")
    void givenLineWithSizeLessThanTwo_whenCreateLine_thenThrowException() {
        PointX pointX1 = new PointX(0);

        assertThatThrownBy(() -> new Line(Arrays.asList(pointX1)))
            .isInstanceOf(IllegalArgumentException.class).hasMessage("Line의 크기는 2 이상이어야 합니다.");
    }
}
