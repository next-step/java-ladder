package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static nextstep.ladder.domain.LadderTest.CRONG;
import static nextstep.ladder.domain.LadderTest.FAIL;
import static nextstep.ladder.domain.LadderTest.FIVE_THOUSAND_WON;
import static nextstep.ladder.domain.LadderTest.HONUX;
import static nextstep.ladder.domain.LadderTest.POBI;
import static nextstep.ladder.domain.LadderTest.TEN_THOUSAND_WON;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderResultsTest {

    LadderResults ladderResults;

    @BeforeEach
    void setUp() {
        ladderResults = new LadderResults(List.of(new LadderResult(POBI, TEN_THOUSAND_WON), new LadderResult(HONUX, FIVE_THOUSAND_WON), new LadderResult(CRONG, FAIL)));
    }

    @Test
    void 사다리_실행_결과_반환() {
        assertThat(ladderResults.getResult(POBI)).isEqualTo(TEN_THOUSAND_WON);
        assertThat(ladderResults.getResult(HONUX)).isEqualTo(FIVE_THOUSAND_WON);
        assertThat(ladderResults.getResult(CRONG)).isEqualTo(FAIL);
    }

    @Test
    void 사다리_실행_결과_반환_올바르지_않은_입력() {
        assertThatIllegalArgumentException().isThrownBy(() -> ladderResults.getResult("blabla"));
    }
}
