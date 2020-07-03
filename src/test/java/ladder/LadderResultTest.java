package ladder;

import ladder.domain.LadderResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderResultTest {
    Map<String, String> ladderResult = new HashMap<>();
    {
        ladderResult.put("hello", "1000");
        ladderResult.put("world", "꽝");
        ladderResult.put("test", "풋");
    }

    @Test
    @DisplayName("유효하지 않은 참석자의 결과를 요청할 경우 실패")
    void FailIfRequestInvalidAttendees() {
        LadderResult testResult = new LadderResult(ladderResult);

        assertThatThrownBy(() -> testResult.getLadderResultBy("null"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
