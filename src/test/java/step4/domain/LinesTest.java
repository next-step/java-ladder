package step4.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step4.domain.LadderLevel;
import step4.domain.Line;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {
    @ParameterizedTest
    @CsvSource(value = {"0,1", "1,0", "2,3", "3,2"})
    void 방향을_맞게_안내해주는지(int startIndex, int expectedArrivalIndex) {
        LadderLevel lines = new LadderLevel(List.of(new Line(true), new Line(true), new Line(true)));
        assertThat(lines.getDirection(startIndex)).isEqualTo(expectedArrivalIndex);
    }
}
