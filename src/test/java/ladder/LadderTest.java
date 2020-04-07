package ladder;

import ladder.domain.Line;
import ladder.domain.ladder.LadderLine;
import org.junit.jupiter.api.Test;

public class LadderTest {
    @Test
    void createLineTest() {
        int person = 5;
        Line line = new LadderLine(person);
        line.getLine().stream().forEach((l)-> System.out.print(l));
    }
}
