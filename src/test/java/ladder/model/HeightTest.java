package ladder.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class HeightTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    public void 높이가_양수가_아니면_예외가_난다(int value) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Height(value)
        );
    }

}