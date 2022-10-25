package nextstep.laddar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    void createLine() {
        Line line = new Line(4, new RandomGenerator());
        assertThat(line.getPositions()).hasSize(4);
    }

    @Test
    @DisplayName("위치에 가로라인설치 정상")
    void createHorizontalLine() {
        Line line = new Line(4, new TrueGenerator());

        List<Boolean> positions = line.getPositions();
        assertThat(positions).containsExactly(true, false, true, false);
    }

    @Test
    void goOneStepToRight() {
        Line line = new Line(4, new TrueGenerator());
        int position = line.goOneStep(0);
        assertThat(position).isEqualTo(1);
    }

    @Test
    void goOneStepToLeft() {
        Line line = new Line(4, new TrueGenerator());
        int position = line.goOneStep(1);
        assertThat(position).isEqualTo(0);
    }
}
