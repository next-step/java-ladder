package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ResultGeneratorTest {

    private Map<Integer, String> ladderResult = new HashMap<>();;
    private String inputText = "꽝, 5000, 꽝";

    @BeforeEach
    void setUp() {
        ladderResult.put(0, "꽝");
        ladderResult.put(1, "5000");
        ladderResult.put(2, "꽝");
    }

    @DisplayName("사다리 결과 나누기 테스트")
    @Test
    void testCreateResult() {
        LadderResult expected = new LadderResult(ladderResult);
        LadderResult actual = new ResultGenerator(inputText).generate();

        assertThat(expected).isEqualTo(actual);
    }
}
