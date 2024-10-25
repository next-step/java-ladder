package ladder;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    private List<Boolean> lines;

    @Test
    public void create() {
        Line line = new Line(4);
        assertThat(line).isEqualTo(new Line(4));
    }

    @Test
    public void createLine() {
        Line line = new Line(4);
        line.createLine(5);
        assertThat(line.getLines()).hasSize(3);
    }
}
