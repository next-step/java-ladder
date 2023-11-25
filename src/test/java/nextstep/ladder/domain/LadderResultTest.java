package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderResultTest {
    @DisplayName("사다리의 결과는 비었거나 공백이면 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void 사다리_결과가_비었을때(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Result(2, input);
        });
    }

    @DisplayName("참가자의 수와 사다리 결과의 수가 다르면 예외가 발생한다.")
    @Test
    void 참가자의_수와_사다리의_결과의수가_다를떄() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Result(2, "aa,bb,cc");
        });
    }
}