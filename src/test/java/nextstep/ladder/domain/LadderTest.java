package nextstep.ladder.domain;

import nextstep.ladder.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    @DisplayName("사다리타기 결과를 제공한다")
    void ladderResultTest() {
        String userRaw = "a,bb,ccc,dd";
        String resultRaw = "ar,bbr,cccr,ddr";

        Ladder ladder = Ladder.random(userRaw, resultRaw, 5);
        Results results = ladder.getResults();

        assertThat(results.getResults()).extracting("resultName")
                .containsExactly("ar", "bbr", "cccr", "ddr");
    }

}