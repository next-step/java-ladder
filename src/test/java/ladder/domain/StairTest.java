package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StairTest {
    @DisplayName("첫 계단은 존재하지 않는다.")
    @Test
    void first() {
        Stair actual = new Stair().first();

        assertThat(actual.getStair()).isFalse();
    }
}