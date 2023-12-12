package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderResultTest {
    @Test
    @DisplayName("결과가 입력되지않으면 예외가 발생한다")
    void create_exception() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> {
            new LadderResult("");
            new LadderResult(null);
        });
    }
}