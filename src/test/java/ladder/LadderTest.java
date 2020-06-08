package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {

    @DisplayName("players가 null이면 NullPointerException")
    @Test
    void nullPlayers() {
        assertThatThrownBy(() -> new Ladder(null, LadderHeight.of(3)))
                .isInstanceOf(NullPointerException.class);
    }

    @DisplayName("ladderHeight이 null이면 NullPointerException")
    @Test
    void nullLadderHeight() {
        Players players = Players.of(Arrays.asList(PlayerName.of("name1"), PlayerName.of("name2")));

        assertThatThrownBy(() -> new Ladder(players, null))
                .isInstanceOf(NullPointerException.class);
    }
}
