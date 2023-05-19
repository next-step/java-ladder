package nextstep.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {

    @Test
    void 라인들을_생성한다() {
        // given & when
        Lines lines = new Lines(4, 3);

        // then
        assertThat(lines.getLines().size()).isEqualTo(3);
    }

    @Test
    void 사다리의_목적지를_찾는다() {
        // given
        List<Line> tempLines = new ArrayList<>();
        Line line1 = new Line(List.of(true, false));
        Line line2 = new Line(List.of(false, true));
        tempLines.add(line1);
        tempLines.add(line2);
        Lines lines = new Lines(tempLines);

        // when
        int result = lines.findDestination(0);

        // then
        assertThat(result).isEqualTo(2);
    }
}
