package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PlayersTest {

    @Test
    void createPlayers() {
        Players players = Players.getNewInstanceByStrings(new String[]{"a", "b", "c", "d"});
        assertThat(players).isEqualTo(Players.getNewInstanceByStrings(new String[]{"a", "b", "c", "d"}));
    }
}