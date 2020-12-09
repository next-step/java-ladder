package ladder.domain.player;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerTest {
    @Test
    void validNameLength() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Player("123456"));
    }

    @Test
    void getName() {
        Assertions.assertThat(new Player("12345").getName())
                .isEqualTo("12345");
    }
}