package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    void create() {
        List<Boolean> points = List.of(true, false, true, false);

        Line line = new Line(points);

        assertThat(line).isNotNull();
        assertThat(line.getPoints()).hasSize(4);

    }
}
