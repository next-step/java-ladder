package step3.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LinesTest {
    @ParameterizedTest
    @CsvSource(value = {"0,1", "1,0", "2,3", "3,2"})
    void 방향을_맞게_안내해주는지(int startIndex, int expectedArrivalIndex) {
        Lines lines = new Lines(List.of(true, false, true));
        assertThat(lines.getDirection(startIndex)).isEqualTo(expectedArrivalIndex);
    }
}