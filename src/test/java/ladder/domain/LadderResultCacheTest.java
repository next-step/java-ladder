package ladder.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderResultCacheTest {
    @Test
    @DisplayName("getSortedResults()는 시작 인덱스에 따라 정렬된 결과를 반환한다")
    void getSortedResults_ReturnsResultsSortedByStartIndex() {
        List<LadderResult> ladderResults = List.of(
            new LadderResult(2, "Charles", "꽝"),
            new LadderResult(0, "Alice", "당첨"),
            new LadderResult(1, "Bob", "보류")
        );

        LadderResultCache cache = new LadderResultCache(ladderResults);
        List<LadderResult> sortedResults = cache.getSortedResults();

        assertThat(sortedResults)
            .extracting(LadderResult::getName)
            .containsExactly("Alice", "Bob", "Charles");
    }

    @Test
    @DisplayName("이름으로 결과를 조회할 수 있다")
    void getResult_WithValidUserName_ReturnsCorrectResult() {
        List<LadderResult> ladderResults = List.of(
            new LadderResult(0, "Alice", "당첨"),
            new LadderResult(1, "Bob", "보류"),
            new LadderResult(2, "Charlie", "꽝")
        );

        LadderResultCache cache = new LadderResultCache(ladderResults);
        assertThat(cache.getResult("Alice")).isEqualTo("당첨");
        assertThat(cache.getResult("Bob")).isEqualTo("보류");
    }

    @Test
    @DisplayName("존재하지 않는 사용자 이름으로 결과를 조회하면 예외가 발생한다")
    void getResult_WithInvalidUserName_ThrowsException() {
        List<LadderResult> ladderResults = List.of(
            new LadderResult(0, "Alice", "당첨"),
            new LadderResult(1, "Bob", "보류")
        );

        LadderResultCache cache = new LadderResultCache(ladderResults);

        assertThatIllegalArgumentException()
            .isThrownBy(() -> cache.getResult("Charles"));
    }

}
