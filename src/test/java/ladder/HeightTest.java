package ladder;

import ladder.domain.Height;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class HeightTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    public void 입력된_사다리높이가_1미만인_경우_예외가_발생한다(int height) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Height(height));
    }

}
