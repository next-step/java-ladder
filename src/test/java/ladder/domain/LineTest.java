package ladder.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @ParameterizedTest
    @CsvSource(value = {
            "0,1",
            "1,0",
            "2,2",
            "3,4",
            "4,3"
    })
    void nextPosition(Integer position, Integer expected) {
        List<Boolean> bridges = List.of(true, false, false, true);
        Line line = new Line(bridges);

        assertThat(line.nextPosition(new Position(position))).isEqualTo(new Position(expected));
    }
}
