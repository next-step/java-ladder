package nextstep.ladder;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderMaxHeightTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1})
    void test(int value) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LadderMaxHeight(value));
    }
}
