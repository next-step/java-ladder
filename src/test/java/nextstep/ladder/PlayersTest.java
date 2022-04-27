package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PlayersTest {

    @Test
    void createPlayers() {
        Players players = new Players(new String[]{"a", "b", "c", "d"});
        assertThat(players).isEqualTo(new Players(new String[]{"a", "b", "c", "d"}));
    }
}