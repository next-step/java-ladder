package ladder;

import ladder.domain.LadderResult;
import ladder.domain.LadderResults;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderResultsTest {

    @DisplayName("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)")
    @Test
    void getResultCountTest() {
        String reulstsString = "꽝,꽝,5000원,5000";
        LadderResults ladderResults = new LadderResults(reulstsString);
        LadderResult ladderResult = new LadderResult("꽝", 0);

        assertThat(ladderResults.getResultCount()).isEqualTo(4);
        assertThat(ladderResults.getResult(ladderResult)).isEqualTo(ladderResult);

    }

    @DisplayName("ladderResult 객체 테스트")
    @Test
    void getResultByPositionIndexTest() {
        String reulstsString = "1000";
        LadderResults ladderResults = new LadderResults(reulstsString);
        LadderResult ladderResult = new LadderResult("1000", 0);

        assertThat(ladderResults.getResultByPositionIndex(0)).isEqualTo(ladderResult);
    }

}
