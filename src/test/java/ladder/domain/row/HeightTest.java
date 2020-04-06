package ladder.domain.row;

import ladder.model.row.Height;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class HeightTest {
    @DisplayName("height는 양수여야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void throwExceptionWhenNotPositive(int input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Height(input);
        });
    }
}