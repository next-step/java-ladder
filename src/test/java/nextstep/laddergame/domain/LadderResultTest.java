package nextstep.laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LadderResultTest {
    @DisplayName("특정 참여자의 결과를 반환한다.")
    @Test
    void outputOf() {
        Map<String, String> ladderResults = new HashMap<>() {
            {
                put("moon", "꽝");
                put("yoonji", "2000");
            }
        };
        LadderResult given = new LadderResult(ladderResults);

        String actual = given.outputOf("moon");

        assertThat(actual).isEqualTo("꽝");
    }

    @DisplayName("게임 결과가 저장되어 있는 참여자들의 이름을 반환한다.")
    @Test
    void keys() {
        Map<String, String> ladderResults = new HashMap<>() {
            {
                put("moon", "꽝");
                put("yoon", "2000");
            }
        };
        LadderResult given = new LadderResult(ladderResults);

        Set<String> actual = given.keys();

        assertThat(actual).containsExactly("moon", "yoon");
    }
}
