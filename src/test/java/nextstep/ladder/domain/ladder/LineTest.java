package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    @Test
    void create() {
        LineMaterial lineMaterial = LineMaterial.of(10, () -> false);
        Line line = Line.from(lineMaterial);

        System.out.println(line.toString());
    }

    @ParameterizedTest
    @CsvSource(value = {"1,false,0", "2,false,0", "2,true,1", "3,false,0", "3,true,1"})
    void move(int sizeOfPoint, boolean isDirection, int expected) {
        LineMaterial lineMaterial = LineMaterial.of(sizeOfPoint, () -> isDirection);
        Line line = Line.from(lineMaterial);

        assertThat(line.move(Location.init())).isEqualTo(Location.from(expected));
    }
}
