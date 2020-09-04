package ladder;

import ladder.domain.Line;
import ladder.domain.BarType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LineTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 4, 6, 8, 10, 15, 20})
    public void allTrueLineTest(int personCount) {

        Line line = new Line(personCount, () -> true);
        assertEquals(line.getBarTypes().size(), personCount);

        List<String> lineList = new ArrayList<>();

        for (int i = 0; i < personCount; i++) {

            if (i % 2 != 0) {
                lineList.add(BarType.LEFT.getBar());
                continue;
            }

            lineList.add(BarType.NONE.getBar());
        }

        assertEquals(lineList, line.getBarTypes());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 4, 6, 8, 10, 15, 20})
    public void allFalseLineTest(int personCount) {

        Line line = new Line(personCount, () -> false);
        assertEquals(line.getBarTypes().size(), personCount);

        List<String> lineList = new ArrayList<>();

        for (int i = 0; i < personCount; i++) {
            lineList.add(BarType.NONE.getBar());
        }

        assertEquals(lineList, line.getBarTypes());
    }
}
