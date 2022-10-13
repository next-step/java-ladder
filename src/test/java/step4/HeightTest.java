package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step4.domain.Height;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class HeightTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("height에 0 이하의 값이 들어오면 에러 발생")
    void validateHeight(int height) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Height(height));
    }
}