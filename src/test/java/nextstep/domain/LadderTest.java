package nextstep.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @Test
    @DisplayName("높이에 맞춰서 Line이 생성된다.")
    void createLinesTest() {
        int columns = 4, height = 6;
        Ladder ladder = Ladder.of(columns, height);
        assertEquals(height, ladder.height());
    }

    @Test
    @DisplayName("모든 행이 false로만 이루어져 있다면, 출발과 도착 위치가 같다.")
    void playStraightTest() {
        int columns = 4, height = 6;
        List<Boolean> falseEdge = Collections.nCopies(columns - 1, false);
        List<Line> straightLine = IntStream.range(0, height)
            .mapToObj(i -> Line.ofManual(columns, falseEdge))
            .collect(Collectors.toList());

        Ladder ladder = new Ladder(straightLine);

        for (int start = 0; start < columns; start++) {
            assertEquals(start, ladder.play(start));
        }
    }
}
