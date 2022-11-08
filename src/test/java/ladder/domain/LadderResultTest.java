package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderResultTest {

    @DisplayName("생성")
    @Test
    void create() {
        LadderResult ladderResult = new LadderResult("꽝");
        Assertions.assertThat(ladderResult)
                  .isEqualTo(new LadderResult("꽝"));
    }

    @ParameterizedTest(name = "생성 실패 - {0}")
    @NullSource
    @ValueSource(strings = {"", " "})
    void invalid(final String input) {
        assertThatThrownBy(() -> new LadderResult(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사다리 결과는 빈 문자열일 수 없습니다.");
    }
}
