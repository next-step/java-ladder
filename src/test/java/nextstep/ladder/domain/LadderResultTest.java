package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderResultTest {

    @Test
    @DisplayName("결과값을 등록한다.")
    void input_result_test() {
        String result = "꽝";

        LadderResult ladderResult = new LadderResult(result);

        assertThat(ladderResult.getResult()).isEqualTo(result);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("결과 값이 비어있는 경우 예외가 발생한다.")
    void input_empty_exception_test(String result) {
        assertThatThrownBy(() ->
                new LadderResult(result)
        ).isInstanceOf(IllegalArgumentException.class);
    }

}
