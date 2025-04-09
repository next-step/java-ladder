package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LineTest {
    @Test
    void createTest() {
        Line line = new Line(3, () -> true);

        assertThat(line).isEqualTo(new Line(List.of(true, false)));
    }

    @Test
    void createListTest() {
        Line line = new Line(List.of(true, false, false));

        assertThat(line).isEqualTo(new Line(List.of(true, false, false)));
    }

    @Test
    void getPointsTest() {
        Line line = new Line(List.of(true, false, false));

        assertThat(line.getPoints()).isEqualTo(List.of(true, false, false));
    }
}
