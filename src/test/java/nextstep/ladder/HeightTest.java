package nextstep.ladder;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class HeightTest {

    @Test
    void LadderHeightCreateFailureTest() {
        assertThatThrownBy(() -> new Height(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
