package ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {
    @Test
    public void 여러_사람_생성() {
        // given
        // when
        final Players players = new Players("pobi", "honux", "crong", "jk");

        // then
        assertThat(players.getNumberOfPlayers()).isEqualTo(4);
        assertThat(players.getPlayer(0)).isNotNull();
    }
}