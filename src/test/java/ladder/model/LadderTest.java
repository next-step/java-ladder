package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LadderTest {

    private final Ladder ladder = getLadder();

    @Test
    @DisplayName("Ladder 생성자 테스트")
    void testLadder_ShouldReturnLadder() {
        assertEquals(ladder.getHeightOfLadder(), 2);
        assertAll(
                "Assert the first ladder",
                () -> assertEquals(3, ladder.getNthOfLadder(0).getSizeOfLine()),
                () -> assertEquals(true, ladder.getNthOfLadder(0).isConnectedToNextLadder(0)),
                () -> assertEquals(false, ladder.getNthOfLadder(0).isConnectedToNextLadder(1)),
                () -> assertEquals(false, ladder.getNthOfLadder(0).isConnectedToNextLadder(2))
        );
        assertAll(
                "Assert the second ladder",
                () -> assertEquals(3, ladder.getNthOfLadder(1).getSizeOfLine()),
                () -> assertEquals(false, ladder.getNthOfLadder(1).isConnectedToNextLadder(0)),
                () -> assertEquals(true, ladder.getNthOfLadder(1).isConnectedToNextLadder(1)),
                () -> assertEquals(false, ladder.getNthOfLadder(1).isConnectedToNextLadder(2))
        );
    }

    @ParameterizedTest(name = "해당 index에서 사다리 타기 진행시, 최종 도착지점을 반환")
    @CsvSource(value = {"0:2", "1:0", "2:1"}, delimiter = ':')
    void testLadder_getLastPositionAt(int index, int destination) {
        assertEquals(ladder.getLastPositionAt(index), destination);
    }

    private Ladder getLadder() {
        List<Line> lines = new ArrayList<>();
        Line line1 = Line.of(
                            List.of(
                                    Point.of(false, true),
                                    Point.of(true, false),
                                    Point.of(false, false)
                            )
                    );
        Line line2 = Line.of(
                            List.of(
                                    Point.of(false, false),
                                    Point.of(false, true),
                                    Point.of(true, false)
                            )
                    );
        lines.add(line1);
        lines.add(line2);
        return new Ladder(lines);
    }

}
