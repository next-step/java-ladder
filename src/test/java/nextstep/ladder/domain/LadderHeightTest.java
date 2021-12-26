package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderHeightTest {
    @Test
    public void create() {
        final int height = 5;
        assertThat(LadderHeight.of(height)).isEqualTo(LadderHeight.of(height));
        assertThat(LadderHeight.of(height).toInt()).isEqualTo(height);
    }

    @ParameterizedTest(name = "create failed: {arguments}")
    @ValueSource(ints = {-1, 0})
    public void createFailed(int invalidHeight) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderHeight.of(invalidHeight))
                .withMessageContaining("larger than 0");
    }

    public static LadderHeight h(int height) {
        return LadderHeight.of(height);
    }
}
