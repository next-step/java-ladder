package nextstep.ladder.domain.ladder.line.strategy;

import nextstep.ladder.domain.ladder.line.HorizontalLines;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HorizontalLinesGenerateSequentialStrategyTest {


    private HorizontalLinesGenerateSequentialStrategy strategy;

    @BeforeEach
    void setUp() {
        strategy = new HorizontalLinesGenerateSequentialStrategy();
    }

    @Test
    @DisplayName("generate 테스트")
    void generateTest() {
        HorizontalLines horizontalLines = strategy.generate(5);

        assertTrue(horizontalLines.findByIndex(0).isPresent());
        assertTrue(horizontalLines.findByIndex(1).isPresent());
        assertTrue(horizontalLines.findByIndex(2).isPresent());
        assertTrue(horizontalLines.findByIndex(3).isPresent());
        assertTrue(horizontalLines.findByIndex(4).isPresent());
        assertFalse(horizontalLines.findByIndex(5).isPresent());
    }
}