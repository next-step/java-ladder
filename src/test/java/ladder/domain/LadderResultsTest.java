package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderResultsTest {

    @Test
    @DisplayName("text blank 설정")
    void testLadderResultsFromTextBlank() {
        assertThatThrownBy(() -> LadderResults.fromText("")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LadderResults.fromText(" ")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LadderResults.fromText(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("실행 결과 정상 생성")
    void testCreateLadderResults() {
        // given
        String[] results = { "꽝","5000","꽝!","3000" };
        // when
        LadderResults ladderResults = LadderResults.fromText(String.join(",", results));
        // then
        for (LadderResult ladderResult : ladderResults) {
            assertThat(results).contains(ladderResult.getResult());
        }
    }

    @Test
    @DisplayName("실행 결과 크기")
    void testLadderResultsSize() {
        // given
        String[] results = { "꽝","5000","꽝!","3000" };
        // when
        LadderResults ladderResults = LadderResults.fromText(String.join(",", results));
        // then
        assertThat(ladderResults.size()).isEqualTo(results.length);
    }
}
