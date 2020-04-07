package ladder;

import ladder.ladder.Line;
import org.junit.jupiter.api.Test;

public class LadderTest {
    @Test
    void createLineTest() {
        int person = 10;
        Line line = new Line(person);
        line.getLine().stream().forEach((l)-> System.out.print(l));
    }
}
