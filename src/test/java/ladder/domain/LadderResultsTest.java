package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderResultsTest {

    @Test
    void ladderResultAt() {
        LadderResults ladderResults = ladderResults();
        LadderResult ladderResult = ladderResults.ladderResultAt(new Position(0));

        assertThat(ladderResult).isEqualTo(new LadderResult("꽝"));
    }

    @DisplayName("포지션에 해당하는 사다리 결과가 없으면 예외 발생")
    @Test
    void ladderResultAt_fail() {
        LadderResults ladderResults = ladderResults();

        assertThatThrownBy(() -> ladderResults.ladderResultAt(new Position(4)))
                .isInstanceOf(NoSuchElementException.class);
    }

    private static LadderResults ladderResults() {
        return new LadderResults(List.of(
                new LadderResult("꽝"),
                new LadderResult("1000"),
                new LadderResult("2000"),
                new LadderResult("꽝")));
    }
}
