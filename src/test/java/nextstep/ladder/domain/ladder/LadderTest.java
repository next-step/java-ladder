package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.ladder.factory.LadderFactory;
import nextstep.ladder.domain.ladder.line.HorizontalLine;
import nextstep.ladder.domain.ladder.line.strategy.HorizontalLinesGenerateStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LadderTest {

    private static final int HEIGHT = 5;
    private Ladder prevLadder;
    private Ladder ladder;

    @BeforeEach
    void setUp() {
        prevLadder = LadderFactory.generateWith(HEIGHT, generateStrategy());
        ladder = LadderFactory.generateWith(HEIGHT, generateStrategy());
    }

    @Test
    @DisplayName("이전 사다리와 중복되는 라인은 지운다")
    void removeDuplicatedHorizontalLines() {
        List<HorizontalLine> horizontalLines = ladder.getHorizontalLines();

        assertTrue(horizontalLines.get(0).exist());
        assertTrue(horizontalLines.get(1).exist());
        assertTrue(horizontalLines.get(2).exist());
        assertTrue(horizontalLines.get(3).exist());

        ladder.removeDuplicatedHorizontalLines(prevLadder);

        assertFalse(horizontalLines.get(0).exist());
        assertFalse(horizontalLines.get(1).exist());
        assertFalse(horizontalLines.get(2).exist());
        assertFalse(horizontalLines.get(3).exist());
    }

    private HorizontalLinesGenerateStrategy generateStrategy() {
        return (count) -> {
            List<HorizontalLine> horizontalLines = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                HorizontalLine horizontalLine = new HorizontalLine(true);
                horizontalLines.add(horizontalLine);
            }
            return horizontalLines;
        };
    }
}