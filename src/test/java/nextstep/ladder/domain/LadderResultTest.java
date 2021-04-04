package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderResultTest {

    @DisplayName("LadderResult 생성 테스트")
    @Test
    void create_생성_테스트() {
        // given
        LadderResult ladderResult = LadderResult.valueOf("꽝", "5000");
        // when
        LadderResult expected = LadderResult.valueOf("꽝", "5000");
        // then
        assertThat(ladderResult).isEqualTo(expected);
    }
}
