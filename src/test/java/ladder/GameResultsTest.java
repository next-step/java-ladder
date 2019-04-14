package ladder;

import ladder.domain.BetItems;
import ladder.domain.GameResults;
import ladder.domain.Player;
import ladder.domain.Players;
import ladder.support.FixedGameResults;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultsTest {
    @Test
    public void 이름으로_플레이어_찾기() {
        // given
        Players players = Players.valueOfComma("a,b,c,d");
        BetItems betItems = BetItems.valueOfComma("에이,비,씨,디");
        GameResults gameResults = FixedGameResults.ofPlayersAndBetItems(players, betItems);
        // when
        List<Player> foundPlayers = gameResults.match("a");
        // then
        assertThat(foundPlayers.size()).isEqualTo(1);
        assertThat(gameResults.find(foundPlayers.get(0)).toString().trim()).isEqualTo("에이");
    }

    @Test
    public void 이름으로_플레이어_찾기_중복시() {
        // given
        Players players = Players.valueOfComma("a,b,a,d");
        BetItems betItems = BetItems.valueOfComma("에이,비,씨,디");
        GameResults gameResults = FixedGameResults.ofPlayersAndBetItems(players, betItems);
        // when
        List<Player> foundPlayers = gameResults.match("a");
        // then
        assertThat(foundPlayers.size()).isEqualTo(2);
    }

    @Test
    public void 결과찾기() {
        // given
        Players players = Players.valueOfComma("a,b,c,d");
        BetItems betItems = BetItems.valueOfComma("에이,비,씨,디");
        GameResults gameResults = FixedGameResults.ofPlayersAndBetItems(players, betItems);
        // when
        List<Player> foundPlayers = gameResults.match("a");
        Player player = foundPlayers.get(0);
        // then
        assertThat(gameResults.find(player).toString().trim()).isEqualTo("에이");
    }
}
