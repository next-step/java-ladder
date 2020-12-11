package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameSetupTest {

    @Test
    @DisplayName("GameSetup 객체 비교")
    void gameSetup_isEqualTo() {
        GameSetup actual = GameSetup.of(5,5);
        assertThat(actual).isEqualTo(GameSetup.of(5,5));
    }
}
