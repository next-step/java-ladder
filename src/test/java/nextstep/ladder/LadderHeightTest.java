package nextstep.ladder;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderHeightTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1})
    void invalid_height(int value) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LadderHeight(value));
    }
}
