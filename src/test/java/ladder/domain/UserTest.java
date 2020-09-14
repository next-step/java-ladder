package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UserTest {
    @Test
    void validNameLength() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new User("123456"));
    }

    @Test
    void getName() {
        Assertions.assertThat(new User("12345").getName())
                .isEqualTo("12345");
    }
}