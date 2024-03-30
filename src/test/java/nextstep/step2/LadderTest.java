package nextstep.step2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @Test
    void 사다리를_생성한다() {
        int width = 5;
        int height = 4;
        Ladder ladder = new Ladder(height, width, new RandomPointGenerator());

        Assertions.assertEquals(width, ladder.getLines().size());
        for (Line line : ladder.getLines()) {
            Assertions.assertEquals(height, line.getPoints().size());
        }
    }
}
