package step2.domain;

import org.junit.jupiter.api.Test;
import step2.dto.Player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {
    @Test
    void createFail() {
        assertThatThrownBy(() -> new Player("abcdef"))
                .isExactlyInstanceOf(RuntimeException.class);
    }

    @Test
    void createSuccess() {
        final String nameValue = "abcde";
        final Player player = new Player(nameValue);
        assertThat(player).isEqualTo(new Player(nameValue));
    }
}