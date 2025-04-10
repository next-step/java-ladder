package nextstep.ladder.module;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.ladder.view.ResultView;

public class PointXTest {

    private final ResultView resultView = new ResultView();
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Test
    @DisplayName("x가 0 미만이면 에러")
    void givenXLessThanZero_whenCreatePointX_thenThrowException() {
        assertThatThrownBy(() -> new Point(-1, new Bridge())).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("x는 0 이상이어야 합니다.");
    }

    @Test
    @DisplayName("x가 0 이상이면 통과")
    void givenXGreaterThanOrEqualToZero_whenCreatePointX_thenPass() {
        assertThat(new Point(0, new Bridge()).value()).isEqualTo(0);
    }

    @Test
    @DisplayName("Bridge 가 있을 때 출력 점검")
    void givenBridge_whenToString_thenPrintBridge() {
        Point point = new Point(0, new Bridge(true));
        System.setOut(new PrintStream(outputStream));
        resultView.printPoint(point);
        assertThat(outputStream.toString()).isEqualTo("-----|");
    }

    @Test
    @DisplayName("Bridge 가 없을 때 출력 점검")
    void givenNoBridge_whenToString_thenPrintNoBridge() {
        Point point = new Point(0);
        System.setOut(new PrintStream(outputStream));
        resultView.printPoint(point);
        assertThat(outputStream.toString()).isEqualTo("     |");
    }

}
