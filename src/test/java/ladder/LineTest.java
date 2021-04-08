package ladder;

import ladder.domain.Line;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    public void Line_Point_수_Test(){
        Line line = new Line(10);
        assertThat(line.points().size()).isEqualTo(10);
    }
}
