import domain.Line;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    void Line() {
        Line line = new Line(4);
        assertThat(line.getLine().size()).isEqualTo(3);
    }
}
