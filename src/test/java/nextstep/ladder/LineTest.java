package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    void create() {
        Line line = new Line(4);
        assertThat(line.points().size()).isEqualTo(4 - 1);
    }
}
