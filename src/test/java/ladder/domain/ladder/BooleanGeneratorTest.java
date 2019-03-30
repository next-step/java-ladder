package ladder.domain.ladder;

import ladder.domain.enums.Complexity;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BooleanGeneratorTest {

    @Test
    public void 난이도_상일경우_TRUE() {
        assertTrue(BooleanGenerator.createBooleanByComplexity(Complexity.HARD));
    }

    @Test
    public void 난이도_하일경우_FALSE() {
        assertFalse(BooleanGenerator.createBooleanByComplexity(Complexity.EASY));
    }
}
