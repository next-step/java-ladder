package ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    void createLineOnlyTrue() {
        Line line = new Line(4, () -> true);
        assertThat(line.size()).isEqualTo(4);
    }

    @Test
    void move() {
        Line line = new Line(4, () -> true);
        assertThat(line.move(0)).isEqualTo(1);
    }

    @Test
    void lastPoint() {
        Line line = new Line(4, () -> true);
        assertThat(line.lastPoint().getIndex()).isEqualTo(3);
    }

    @Test
    void firstPoint() {
        Line line = new Line(4, () -> true);
        line.addFirstPoint(() -> true);
        assertThat(line.lastPoint().getIndex()).isEqualTo(0);
    }
}