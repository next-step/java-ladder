package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    public void move() {
        Line line = new Line(3);
        assertThat(line.move(0)).isNotEqualTo(line.move(1)).isNotEqualTo(line.move(2));
    }
}
