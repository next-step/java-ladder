package ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PlayersTest {
    @Test
    void create() {
        Players players = new Players("test,name,jojo,popo");
        assertThat(players.getPlayers().size()).isEqualTo(4);
    }
}