package ladder.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderHeightTest {
    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "2a"})
    void testFailWhenInvalidInput(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LadderHeight(input));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void testFailWhenNullOrEmpty(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LadderHeight(input));
    }
}
