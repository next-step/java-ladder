package nextstep.step2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class LadderTest {

    @Test
    void 사다리를_생성한다() {
        int height = 4;
        int humanCount = 5;
        Ladder ladder = new Ladder(height, humanCount, new RandomPointGenerator());

        Assertions.assertEquals(humanCount, ladder.getLines().size());
        for (Line line : ladder.getLines()) {
            Assertions.assertEquals(height, line.getPoints().size());
        }
    }

    @Test
    void 마지막_선의_모든_점은_false이다() {
        int humanCount = 4;
        int height = 5;
        Ladder ladder = new Ladder(height, humanCount, new RandomPointGenerator());

        Line lastLine = ladder.getLines().get(humanCount - 1);
        for (boolean point : lastLine.getPoints()) {
            assertFalse(point);
        }
    }

    @Test
    void 선을_잇는_선은_연속해서_생성되지_않는다() {
        int height = 5;
        int humanCount = 4;
        PointGenerator pointGenerator = () -> true;

        Ladder ladder = new Ladder(height, humanCount, pointGenerator);
        List<Line> lines = ladder.getLines();

        for (int i = 1; i < lines.size(); i++) {
            Line prevLine = lines.get(i - 1);
            Line currLine = lines.get(i);

            for (int j = 0; j < height; j++) {
                assertFalse(prevLine.getPoints().get(j) && currLine.getPoints().get(j));
            }
        }
    }
}
