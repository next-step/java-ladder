package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderResultTest {
    @Test
    @DisplayName("사다리 실행결과를 입력하면 사다리 실행결과가 생성된다.")
    void inputResult_CreateLadderResultTest_isEqualToResult() {
        assertThat(new LadderResult("꽝")).isEqualTo(new LadderResult("꽝"));
        assertThat(new LadderResult("5000")).isEqualTo(new LadderResult("5000"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "500000", "오만원권드립니다."})
    @DisplayName("사다리 결과가 1~5자 사이가 아니면 에러 발생한다.")
    void inputResult_unmatchedSize_occurredException(String input) {
        assertThatThrownBy(() -> new LadderMember(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
