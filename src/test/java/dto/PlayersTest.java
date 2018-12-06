package dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {

    @Test
    public void 플레이어_수() {
        Players players = new Players("가,나,다,라");
        assertThat(players.size()).isEqualTo(4);

    }

    @Test
    public void 플레이어가져오기() {
        Players players = new Players("가,나,다,라");
        assertThat(players.hasPlayer("가").getName()).isEqualTo("가");

    }
}
