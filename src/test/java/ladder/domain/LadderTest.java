package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    private final List<Line> lines = new ArrayList<>();

    @BeforeEach
    void setup() {
        List<Boolean> points1 = Arrays.asList(false, true, false, false);
        List<Boolean> points2 = Arrays.asList(false, false, true, false);
        lines.add(new Line(points1));
        lines.add(new Line(points2));
    }

    @ParameterizedTest
    @CsvSource(value = {"0,2", "2,1"})
    @DisplayName("사다리 타기")
    void move(int location, int expected) {
        Ladder ladder = new Ladder(lines);
        int arrivalResult = ladder.move(location);
        assertThat(arrivalResult).isEqualTo(expected);
    }
}
