package nextstep.ladder;

import nextstep.ladder.domain.GameResults;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class GameResultTest {
    @Test
    @DisplayName("참가하지 않은 사람의 이름을 입력할 경우 Exception을 반환한다.")
    void assertValidParticipant() {
        Map<String, String> results = new HashMap<>();
        results.put("pobi", "2000");
        results.put("honux", "꽝");

        GameResults gameResults = new GameResults(results);

        String name = "crong";
        assertThatIllegalArgumentException().isThrownBy(() -> {
            gameResults.getResult(name);
        }).withMessage(String.format(GameResults.NO_PARTICIPANT_ERROR, name));
    }
}
