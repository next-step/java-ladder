package nextstep.ladder.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RailTest {
    @ParameterizedTest(name = "create: {arguments}")
    @ValueSource(ints = {1, 10})
    public void create(int height) {
        assertThat(Rail.of(height)).isEqualTo(Rail.of(height));
        assertThat(Rail.of(Height.of(height))).isEqualTo(Rail.of(height));
    }

    @ParameterizedTest(name = "create failed: {arguments}")
    @NullSource
    public void createFailed(Height height) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Rail.of(height))
                .withMessageContaining("cannot be null");
    }
}
