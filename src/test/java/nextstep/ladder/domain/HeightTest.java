package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class HeightTest {
    @Test
    public void create() {
        final int height = 5;
        assertThat(Height.of(height)).isEqualTo(Height.of(height));
        assertThat(Height.of(height).toInt()).isEqualTo(height);
    }

    @ParameterizedTest(name = "create failed: {arguments}")
    @ValueSource(ints = {-1, 0})
    public void createFailed(int invalidHeight) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Height.of(invalidHeight))
                .withMessageContaining("larger than 0");
    }

    public static Height h(int height) {
        return Height.of(height);
    }
}
