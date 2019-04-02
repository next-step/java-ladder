package ladder;

import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {
    @Test
    public void 이름으로_플레이어_찾기() {
        // given
        String selectedPlayer = "이름";
        Players players = new Players("이름,이이름,이름름,름름");
        // when
        Player player = players.match(selectedPlayer);
        // then
        assertThat(player.name).isEqualTo(selectedPlayer);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 없는이름으로_플레이어_찾기() {
        // given
        String selectedPlayer = "이이름름";
        Players players = new Players("이름,이이름,이름름,름름");
        // when
        Player player = players.match(selectedPlayer);
        // then
    }
}
