package nextstep.ladder.module;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    @DisplayName("Line의 시작에는 사다리가 없어야함")
    void givenLineWithBridgeAtStart_whenCreateLine_thenThrowException() {
        Line line = new Line(new PointList(3));

        assertThatThrownBy(() -> line.createLeftBridge(0)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Line의 시작은 사다리가 없어야 합니다.");
    }

    @Test
    @DisplayName("Line의 크기가 2보다 작으면 에러")
    void givenLineWithSizeLessThanTwo_whenCreateLine_thenThrowException() {
        assertThatThrownBy(() -> new Line(new PointList(1))).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Line의 크기는 2 이상이어야 합니다.");
    }
}
