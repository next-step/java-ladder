package ladder.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class LadderFactoryTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    void testFailWhenNotEnoughHeight(int height) {
        assertThatIllegalArgumentException().isThrownBy(() -> LadderFactory.INSTANCE.generateLadder(3, height));
    }

    @Test
    void testSuccessWhenGenerateLadder() {
        assertThatNoException().isThrownBy(() -> LadderFactory.INSTANCE.generateLadder(3,2));
    }
}
