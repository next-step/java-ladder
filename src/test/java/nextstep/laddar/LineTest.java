package nextstep.laddar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    void createLine() {
        Line line = new Line(4);
        assertThat(line.getPositions()).hasSize(4);
    }

    @Test
    @DisplayName("위치에 가로라인설치 정상")
    void createHorizontalLine() {
        Line line = new Line(4);
        line.putHorizontalLine(1, new TrueGenerator());
        assertThat(line.hasHorizontalLine(1)).isTrue();
    }
}
