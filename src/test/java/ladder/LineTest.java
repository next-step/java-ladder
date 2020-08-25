package ladder;

import ladder.domain.Line;
import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    public void lineTest() {
        Line line = new Line(4);
        line.printRow();
    }
}
