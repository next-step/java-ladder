package ladder.entity;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderHeightTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 10, 15, 50, 100, 0x7fffffff})
    void canGenerateHeight(int input) {
        LadderHeight ladderHeight = new LadderHeight(input);
        assertThat(ladderHeight.height()).isEqualTo(input);
    }
}
