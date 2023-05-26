package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {
    @DisplayName("파라미터에 알맞은 높이를 반환한다.")
    @Test
    public void generateLinesTest() {
        final int countOfPerson = 5;
        final int height = 3;
        Lines lines = new Lines(countOfPerson, height);
        List<Line> lineList = lines.getLines();

        assertThat(lineList).hasSize(height);
    }

    @DisplayName("사다리 타기 결과로 알맞은 index를 반환한다.")
    @Test
    public void testLines() {
        Lines lines = new Lines(List.of(
                new Line(List.of(true, false, true)),
                new Line(List.of(false, true, false)),
                new Line(List.of(true, false, false)),
                new Line(List.of(false, true, false)),
                new Line(List.of(true, false, true))));

        assertThat(lines.getResultIndex(0)).isEqualTo(0);
        assertThat(lines.getResultIndex(1)).isEqualTo(3);
        assertThat(lines.getResultIndex(2)).isEqualTo(2);
        assertThat(lines.getResultIndex(3)).isEqualTo(1);
    }
}
