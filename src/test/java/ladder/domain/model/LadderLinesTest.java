package ladder.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LadderLinesTest {

    @Test
    @DisplayName("사다리 라인리스트를 확인한다")
    void checkLadderLines() {
        LadderLines ladderLines = LadderLines.of(Arrays.asList(
                LadderLine.of(Arrays.asList(
                        Point.of(Index.of(0), Direction.of(false, true)),
                        Point.of(Index.of(1), Direction.of(true, false)))
                )
        ));

        assertFalse(ladderLines.get().get(0).getLines().get(0).isLeft());
        assertTrue(ladderLines.get().get(0).getLines().get(0).isRight());
    }
}
