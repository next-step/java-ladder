package ladder.domain;

import ladder.util.LadderResultExpression;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderResultsTest {

    @ParameterizedTest
    @CsvSource(value = {"\"꽝,5000,꽝,3000\",3", "\"꽝,5000,꽝,3000\",5"})
    @DisplayName("사다리 실행 결과를 입력한 그 개수와 멤버의 수가 일치하지 않으면 에러 발생한다.")
    void inputLadderResultTest_isNotSameSizeThanMemberCount_occurredException(String results, int memberCount) {
        List<String> ladderResults = LadderResultExpression.validateLadderResult( results);
        assertThatThrownBy(() -> new LadderResults(LadderResults.addResult(ladderResults, memberCount)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리 생성하고, 사다리 실행 결과를 넣어 Result를 반환한다.")
    void test() {
        LadderLine line1 = new LadderLine(List.of(false, true, false, true));
        LadderLine line2 = new LadderLine(List.of(false, false, true, false));
        LadderLine line3 = new LadderLine(List.of(false, true, false, false));
        LadderLine line4 = new LadderLine(List.of(false, false, true, false));
        LadderLine line5 = new LadderLine(List.of(false, true, false, true));
        Ladder ladder = new Ladder(List.of(line1, line2, line3, line4, line5));

        LadderResult result1 = new LadderResult("꽝");
        LadderResult result2 = new LadderResult("5000");
        LadderResult result3 = new LadderResult("꽝");
        LadderResult result4 = new LadderResult("3000");
        LadderResults results = new LadderResults(List.of(result1, result2, result3, result4));
        List<LadderResult> ladderResults = results.playedByMembers(ladder);

        assertThat(ladderResults.get(0)).isEqualTo(new LadderResult(0, "꽝"));
        assertThat(ladderResults.get(1)).isEqualTo(new LadderResult(3, "5000"));
        assertThat(ladderResults.get(2)).isEqualTo(new LadderResult(2, "꽝"));
        assertThat(ladderResults.get(3)).isEqualTo(new LadderResult(1, "3000"));
    }
}
