package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {

    @Test
    void createPlayer_inputValidation_length() {
        assertThatThrownBy(() -> new Player("abcdef")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름은 최소 1자리")
    void createPlayer_inputValidation_empty() {
        assertThatThrownBy(() -> new Player("")).isInstanceOf(IllegalArgumentException.class);
    }
}
