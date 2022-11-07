package ladder.domain;

import ladder.util.LadderResultExpression;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

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
}
