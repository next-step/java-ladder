package nextstep.ladder.module;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    @DisplayName("Line의 시작과 끝이 0과 (n-1)이면 통과")
    void givenPointXsWithStartAndEndZeroAndNMinusOne_whenCreateLine_thenPass() {
        PointList points = new PointList(3);

        assertThat(new Line(points).points()).isEqualTo(points);
    }

    @Test
    @DisplayName("Line의 시작에는 사다리가 없어야함")
    void givenLineWithBridgeAtStart_whenCreateLine_thenThrowException() {
        PointList points = new PointList(3);
        points.get(0).createBridge();
        points.get(1).createBridge();
        points.get(2).createBridge();

        assertThatThrownBy(() -> new Line(points)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Line의 시작은 사다리가 없어야 합니다.");
    }

    @Test
    @DisplayName("Line에서 연속된 사다리가 있으면 안됨")
    void givenLineWithConsecutiveBridges_whenCreateLine_thenThrowException() {
        PointList points = new PointList(4);
        points.get(1).createBridge();
        points.get(2).createBridge();

        assertThatThrownBy(() -> new Line(points)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Line에서 연속된 사다리가 있으면 안됩니다.");
    }

    @Test
    @DisplayName("Line의 크기가 2보다 작으면 에러")
    void givenLineWithSizeLessThanTwo_whenCreateLine_thenThrowException() {
        PointList points = new PointList(1);

        assertThatThrownBy(() -> new Line(points)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Line의 크기는 2 이상이어야 합니다.");
    }
}
