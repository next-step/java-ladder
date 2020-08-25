package ladder;

import ladder.domain.Line;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LineTest {

    @Test
    public void lineTest() {

        int personCount = 4;

        Line line = new Line(personCount);
        assertEquals(line.getLineList().size(), personCount);
    }
}
