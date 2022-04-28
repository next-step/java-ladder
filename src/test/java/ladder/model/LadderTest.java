package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LadderTest {

    @Test
    @DisplayName("사다리가 정상적으로 생성된다")
    void of() {
        assertThat(Ladder.of(5, 4, new RandomStrategy())).isInstanceOf(Ladder.class);
    }

}