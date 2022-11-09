package ladder.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

public class LineFactoryTest {
    @Test
    void testSuccessWhenGenerateLine() {
        assertThatNoException().isThrownBy(() -> LineFactory.INSTANCE.generateRandomLine(3));
    }
}
