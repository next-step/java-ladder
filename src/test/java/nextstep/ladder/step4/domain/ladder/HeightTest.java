package nextstep.ladder.step4.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class HeightTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void create(int height) {
        assertThat(new Height(height).height()).isEqualTo(height);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void exception(int height) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Height(height));
    }

}
