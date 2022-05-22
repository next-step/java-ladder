package nextstep.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderResultTest {
    @Test
    void 유저인덱스를_찾을수_없는_경우() {
        LadderResult ladderResult = new LadderResult(Arrays.asList("꽝","성공"));
        ladderResult.addResultIndex(1);
        ladderResult.addResultIndex(0);
        assertThatThrownBy(() -> {
            ladderResult.find(3);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}