package ladder;

import ladder.domain.Line;
import ladder.domain.LineType;
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
        assertEquals(line.getLineList().size(), personCount);

        List<String> lineList = new ArrayList<>();

        for (int i = 0; i < personCount; i++) {

            if (i % 2 != 0) {
                lineList.add(LineType.TRUE.lineString());
                continue;
            }

            lineList.add(LineType.FALSE.lineString());
        }

        verifyList(lineList, line.getLineList());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 4, 6, 8, 10, 15, 20})
    public void allFalseLineTest(int personCount) {

        Line line = new Line(personCount, () -> false);
        assertEquals(line.getLineList().size(), personCount);

        List<String> lineList = new ArrayList<>();

        for (int i = 0; i < personCount; i++) {
            lineList.add(LineType.FALSE.lineString());
        }

        verifyList(lineList, line.getLineList());
    }

    private void verifyList(List<String> lineList1, List<String> lineList2) {

        assertEquals(lineList1.size(), lineList2.size());

        for (int i = 0; i < lineList1.size(); i++) {
            assertEquals(lineList1.get(i), lineList2.get(i));
        }

    }
}
