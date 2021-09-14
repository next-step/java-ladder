package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderResultsTest {

    @Test
    @DisplayName("결과값들을 등록한다.")
    void input_result_test() {
        String result = "꽝,5000,꽝,3000";
        int expected = 4;
        LadderResults ladderResults = new LadderResults(result);

        assertThat(ladderResults.countOfLadderResults()).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("결과 값들이 비어있는 경우 예외가 발생한다.")
    void input_empty_exception_test(String result) {
        assertThatThrownBy(() ->
                new LadderResults(result)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}