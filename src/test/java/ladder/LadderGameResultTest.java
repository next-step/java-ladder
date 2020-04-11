package ladder;

import ladder.domain.LadderGameResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameResultTest {
    private LadderGameResult ladderGameResult;

    @BeforeEach
    void setUp() {
        Map<String, String> result = new HashMap<>();
        result.put("11", "aa");
        result.put("22", "bb");
        result.put("33", "cc");
        ladderGameResult = new LadderGameResult(result);
    }

    @Test
    @DisplayName("플레이어 결과 가져오기")
    void getPlayerResultTest() {
        assertThat(ladderGameResult.getPlayerResult("22")).isEqualTo("bb");
    }
}
