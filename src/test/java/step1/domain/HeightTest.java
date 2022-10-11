package step1.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class HeightTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void validateHeight(int height) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Height(height));
    }
}