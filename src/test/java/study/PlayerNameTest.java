package study;

import org.junit.jupiter.api.Test;
import study.core.PlayerName;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerNameTest {

    @Test
    void validate_5자_초과() {
        assertThatThrownBy(() -> new PlayerName("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
