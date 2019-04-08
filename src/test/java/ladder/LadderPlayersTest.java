package ladder;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderPlayersTest {


    @Test
    public void 플레이어_3명_생성() {
        LadderPlayers players = LadderPlayers.createPlayers("일,이,삼");
        assertThat(players.getPlayers().size()).isEqualTo(3);

    }
}