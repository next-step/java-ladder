package ladder.domain;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LadderResultCalculatorTest {

    @DisplayName("Map 생성 테스트")
    @Test
    public void calculateTest() {

        Ladder ladder = new Ladder(5, 5);
        Map<Integer, Integer> map = LadderResultCalculator.calculate(5, ladder);
        assertNotNull(map);
    }
}