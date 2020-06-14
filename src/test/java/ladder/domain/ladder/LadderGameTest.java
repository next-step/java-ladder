package ladder.domain.ladder;

import ladder.domain.player.Players;
import ladder.domain.result.LadderResults;
import ladder.domain.result.MatchResult;
import ladder.domain.strategy.FalseLineStrategy;
import ladder.domain.strategy.TrueLineStrategy;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LadderGameTest {

    @Test
    void findAllResult() {
        LadderGame ladderGame = new LadderGame(Ladder.of(5,5, new FalseLineStrategy()));
        Players players = Players.of("a,b,c,d,e");
        LadderResults ladderResults = LadderResults.of("1,2,3,4,5", players);

        MatchResult result = ladderGame.findAllPosition(players, ladderResults);

        assertThat(result.get(players.get(0))).isEqualTo(ladderResults.get(0));
        assertThat(result.get(players.get(1))).isEqualTo(ladderResults.get(1));
        assertThat(result.get(players.get(2))).isEqualTo(ladderResults.get(2));
        assertThat(result.get(players.get(3))).isEqualTo(ladderResults.get(3));
        assertThat(result.get(players.get(4))).isEqualTo(ladderResults.get(4));
    }

    @Test
    void findOneResult() {
        LadderGame ladderGame = new LadderGame(Ladder.of(2,2, new TrueLineStrategy()));
        Players players = Players.of("a,b");
        LadderResults ladderResults = LadderResults.of("1,2", players);

        int result = ladderGame.findResultPosition(0);

        assertThat(result).isEqualTo(0);
    }
}
