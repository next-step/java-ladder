package ladder.domain.player;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class PlayersTest {

    @Test
    void createPlayers() {
        Players players = Players.of("aaa, bbb, ccc");

        assertThat(players.getCountOfPerson()).isEqualTo(3);
    }

    @Test
    void getPlayerFromName() {
        Players players = Players.of("aaa, bbb, ccc");

        Player player = players.get("aaa");

        assertThat(player.getName()).isEqualTo("aaa");
    }
}
