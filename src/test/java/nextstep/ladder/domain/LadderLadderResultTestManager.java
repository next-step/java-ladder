package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderLadderResultTestManager {

    @Test
    @DisplayName("LottoResult 객체 생성 테스트")
    void create() {
        // given
        final String[] result = {"꽝", "5000", "꽝", "3000"};

        // when
        final LadderResult ladderResult = new LadderResult(result);

        // then
        assertThat(ladderResult.getResultNumber()).isEqualTo(4);
    }
}
