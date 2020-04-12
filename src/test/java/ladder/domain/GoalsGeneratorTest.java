package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class GoalsGeneratorTest {

    private Map<Integer, String> ladderGoals = new HashMap<>();;
    private String inputText = "꽝, 5000, 꽝";

    @BeforeEach
    void setUp() {
        ladderGoals.put(0, "꽝");
        ladderGoals.put(1, "5000");
        ladderGoals.put(2, "꽝");
    }

    @DisplayName("사다리 결과 나누기 테스트")
    @Test
    void testCreateResult() {
        LadderGoals expected = new LadderGoals(ladderGoals);
        LadderGoals actual = new GoalsGenerator(inputText).generate();

        assertThat(expected).isEqualTo(actual);
    }
}
