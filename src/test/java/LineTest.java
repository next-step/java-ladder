import domain.Line;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    void Line() {
        Line line = new Line(4);
        assertThat(line.getLine().size()).isEqualTo(3);
    }

    @Test
    void 중복라인방지() {
        Line line = new Line();
        line.add(true);
        line.add(true);
        assertThat(line.getLine().get(1)).isEqualTo(false);
    }
}
