package nextstep.laddergame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GamerTest {
    @Test
    public void gamers_name_length_test() {
        new Gamer("12345", 0);
        assertThatThrownBy(() -> {
            new Gamer("123456", 0);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}