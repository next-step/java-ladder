package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderNumberTest {
    @Test
    @DisplayName("사다리 번호는 0 부터 가능 하다")
    void validationCheckTest() {
        assertThatThrownBy(() -> LadderNumber.of(-1))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("사다리 번호 겟")
    void getDefaultNumberGetter() {
        assertThat(LadderNumber.of(1).getLadderNo())
                .isEqualTo(1);
    }
}
