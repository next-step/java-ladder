package ladder;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PlayersTest {
    @Test
    void create() {
        Players players = new Players("test,name");
        assertThat(players.getPlayers()).isEqualTo(Arrays.asList(Player.of("test"), Player.of("name")));
    }

    @Test
    void getSize() {
        Players players = new Players("test,name,jojo,popo");
        assertThat(players.getPlayers().size()).isEqualTo(4);
    }

    @Test
    void getIndex() {
        Players players = new Players("test,name,jojo,popo");
        assertThat(players.getIndex("jojo")).isEqualTo(2);
    }
}