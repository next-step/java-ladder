package nextstep.step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderResultTest {
    @Test
    @DisplayName("LadderResult를 생성한다.")
    void testLadderResultCreation() {
        //given, when
        LadderResult ladderResult = new LadderResult();

        //then
        assertThat(ladderResult).isNotNull();
    }
}
