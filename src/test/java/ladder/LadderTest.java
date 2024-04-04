package ladder;

import ladder.domain.Ladder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderTest {
    @Test
    void 사다리_생성() {
        Ladder ladder = new Ladder(5, 4);
        assertThat(ladder).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void 올바르지_않은_사다리_높이(int height) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Ladder(height, 4));
    }
}
