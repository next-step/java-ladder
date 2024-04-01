package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LadderTest {

    @Test
    @DisplayName("Ladder 생성자 테스트")
    void testLadder_ShouldReturnLadder() {
        Ladder ladder = getLadder();

        assertAll(
                () -> assertEquals(2, ladder.getNthOfLadder(0).getSizeOfLine()),
                () -> assertEquals(true, ladder.getNthOfLadder(0).isConnectedLadder(0)),
                () -> assertEquals(false, ladder.getNthOfLadder(0).isConnectedLadder(1))
        );
    }

    private Ladder getLadder() {
        List<Line> lines = new ArrayList<>();
        Line line = new Line(List.of(true, false));
        lines.add(line);
        return new Ladder(lines);
    }

}
