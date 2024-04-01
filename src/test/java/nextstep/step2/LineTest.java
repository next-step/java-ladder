package nextstep.step2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    void 라인을_생성한다() {
        int height = 4;
        Line line = new Line(height, new RandomPointGenerator());

        Assertions.assertEquals(height, line.getPoints().size());
    }
}
