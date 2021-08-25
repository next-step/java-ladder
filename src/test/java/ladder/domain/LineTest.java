package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    @Test
    public void init() {
        Line line = Line.init(5);
        assertThat(line).isInstanceOf(Line.class);
    }

    @Test
    public void move() {
        Line line = Line.init(2);
        assertThat(line.move(0)).isInstanceOf(Integer.class);
    }
}