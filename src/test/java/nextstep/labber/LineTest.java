package nextstep.labber;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    void existLine() {
        Line line = new Line(5) {
            @Override
            protected boolean createPoint() {
                return true;
            }
        };

        assertThat(line.existLine(0)).isTrue();
    }

    @Test
    void size() {
        Line line = new Line(5);

        assertThat(line.size()).isEqualTo(4);
    }
}