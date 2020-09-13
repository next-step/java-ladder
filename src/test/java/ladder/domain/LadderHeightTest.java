package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderHeightTest {

    @Test
    public void LadderHeightTest() {
        assertThatThrownBy(() -> {
            LadderHeight ladderHeight = new LadderHeight(-3);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
