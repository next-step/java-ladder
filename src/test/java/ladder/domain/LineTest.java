package ladder.domain;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LineTest {

    private static final String BAR    = "|-----";
    private static final String PILLAR = "|     ";

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 6, 8, 10, 15, 20})
    public void allTrueLineTest(int personCount) {

        Line line = new Line(personCount, () -> true);
        assertEquals(line.lineToString().size(), personCount);

        List<String> lineList = new ArrayList<>();

        for (int i = 0; i < personCount - 1; i++) {

            if (i % 2 != 0) {
                lineList.add(PILLAR);
                continue;
            }

            lineList.add(BAR);
        }

        lineList.add(PILLAR);

        assertEquals(lineList, line.lineToString());
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 6, 8, 10, 15, 20})
    public void allFalseLineTest(int personCount) {

        Line line = new Line(personCount, () -> false);
        assertEquals(line.lineToString().size(), personCount);

        List<String> lineList = new ArrayList<>();

        for (int i = 0; i < personCount; i++) {
            lineList.add(PILLAR);
        }

        assertEquals(lineList, line.lineToString());
    }
}
