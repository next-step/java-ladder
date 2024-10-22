package ladder;

import static org.assertj.core.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;

class LadderResultTest {

    @Test
    void 생성() {
        Map<String, String> results = Map.of("pobi", "꽝", "lili", "3000");
        LadderResult ladderResult = new LadderResult(results);

        assertThat(ladderResult).isEqualTo(new LadderResult(results));
    }

    @Test
    void 한_참가자에_대한_결과를_반환한다() {
        Map<String, String> results = Map.of("pobi", "꽝", "lili", "3000");
        LadderResult ladderResult = new LadderResult(results);
        String value = ladderResult.getOne("pobi");

        assertThat(value).isEqualTo("꽝");
    }

    @Test
    void 없는_참가자면_에러를_반환한다() {
        Map<String, String> results = Map.of("pobi", "꽝", "lili", "3000");
        LadderResult ladderResult = new LadderResult(results);

        assertThatThrownBy(() -> ladderResult.getOne("dkdk"))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
