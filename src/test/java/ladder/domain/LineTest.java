package ladder.domain;

import ladder.domain.line.*;
import ladder.view.PrintResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {

    private LineStrategy lineStrategy = new RandomLine();

    @Test
    @DisplayName("라인 사이즈 테스트")
    public void lineSizeStest() {
        Line line = Line.of(3, lineStrategy);
        assertThat(line.getPoints().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("2명 이하 테스트")
    public void validationline() {
        assertThatThrownBy(() -> {
            Line line = Line.of(1, lineStrategy);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("라인에 둘다true인 경우 있는지 체크")
    public void lineValidationCheck() {
        Line line = Line.of(7, lineStrategy);
        for (int i = 0; i < line.getPoints().size(); i++) {
            assertThat(line.getPoints().get(i).isNextPoint() && line.getPoints().get(i).isPrevPoint()).isFalse();
        }
    }

    @Test
    @DisplayName("수동 으로 둘다 true를 넣었을 경우 체크")
    public void manualLineTest() {
        LineStrategy lineStrategy2 = new ManualLineTruePoint();
        assertThatThrownBy(() -> {
            Line line = Line.of(7, lineStrategy2);
        }).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("징검다리테스트")
    public void SteppingStoneManualLineTest() {
        LineStrategy steppingStoneManualLine = new SteppingStoneManualLine();
        LineStrategy steppingStoneOthersideLine = new SteppingStoneOthersideLine();
        Line line = Line.of(5, steppingStoneManualLine);
        PrintResult.makeLine(line);
        Line line1 = Line.of(5, steppingStoneOthersideLine);
        PrintResult.makeLine(line1);
        Line line2 = Line.of(5, steppingStoneManualLine);
        PrintResult.makeLine(line2);
        Line line3 = Line.of(5, steppingStoneOthersideLine);
        PrintResult.makeLine(line3);
        Line line4 = Line.of(5, steppingStoneManualLine);
        PrintResult.makeLine(line4);
    }

}
