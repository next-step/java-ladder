package ladder.domain;

import ladder.service.PointGenerator;
import ladder.service.StaticPointGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ladder.support.TestConstants.POINTS;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderTest {
    @DisplayName("Ladder 생성 테스트")
    @Test
    void createLadderTest() {
        int countOfPerson = 4;
        LadderHeight height = new LadderHeight(5);
        PointGenerator pointGenerator = new StaticPointGenerator(POINTS);
        Ladder ladder = new Ladder(countOfPerson, height, pointGenerator);

        List<Line> lines = ladder.getLines();

        assertEquals(height.getHeight(), lines.size());
        assertEquals(countOfPerson - 1, lines.get(0).getPoints().size());
    }
}
