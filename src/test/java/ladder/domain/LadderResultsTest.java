package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderResultsTest {

    @Test
    void findByPosition() {
        LadderResults ladderResults = ladderResults();
        LadderResult ladderResult = ladderResults.findByPosition(0);

        assertThat(ladderResult).isEqualTo(new LadderResult("꽝", 0));
    }

    @DisplayName("포지션에 해당하는 사다리 결과가 없으면 예외 발생")
    @Test
    void findByPosition_fail() {
        LadderResults ladderResults = ladderResults();

        assertThatThrownBy(() -> ladderResults.findByPosition(4))
                .isInstanceOf(NoSuchElementException.class);
    }

    private static LadderResults ladderResults() {
        return new LadderResults(List.of(
                new LadderResult("꽝", 0),
                new LadderResult("1000", 1),
                new LadderResult("2000", 2),
                new LadderResult("꽝", 3)));
    }
}
