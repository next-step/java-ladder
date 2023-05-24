package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LinesTest {

    @DisplayName("파라미터에 알맞은 높이를 반환한다.")
    @Test
    public void generateLinesTest() {
        final int countOfPerson = 5;
        final int height = 3;
        Lines lines = Lines.of(countOfPerson, height);
        List<Line> lineList = lines.getLines();

        assertThat(lineList).hasSize(height);

        for (Line line : lineList) {
            assertThat(line.getPoints()).hasSize(countOfPerson - 1);
        }
    }

}
