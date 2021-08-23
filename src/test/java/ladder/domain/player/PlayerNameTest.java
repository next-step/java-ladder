package ladder.domain.player;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import ladder.exception.InvalidPlayerNameException;
import org.junit.jupiter.api.Test;

class PlayerNameTest {

    @Test
    void of_InvalidNameLength() {
        assertThatThrownBy(() -> PlayerName.of("pororo"))
                .isInstanceOf(InvalidPlayerNameException.class);
    }
}
