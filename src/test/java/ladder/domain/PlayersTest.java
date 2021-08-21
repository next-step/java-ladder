package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayersTest {

    @DisplayName("생성")
    @Test
    void create() {
        String[] splitPlayers = "jenny,jisu,risa,rose".split(",");
        Players players = new Players(splitPlayers);
        assertThat(players.size()).isEqualTo(splitPlayers.length);
    }
}