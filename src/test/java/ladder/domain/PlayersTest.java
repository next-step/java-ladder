package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlayersTest {
    @Test
    void 여러_플레이어들로_Players를_생성하고_Player_리스트를_반환할_수_있다() {
        List<Player> playerList = List.of(new Player("a"), new Player("b"));
        assertThat(new Players(playerList).getPlayerList().containsAll(playerList)).isTrue();
    }

    @Test
    void 플레이어가_몇_명인지_알_수_있다() {
        List<Player> playerList = List.of(new Player("a"), new Player("b"));
        assertThat(new Players(playerList).getPlayerNumber()).isEqualTo(2);
    }
}
