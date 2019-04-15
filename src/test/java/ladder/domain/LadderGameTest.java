package ladder.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    private Players players;

    @Before
    public void setUp() {
        Player player1 = new Player("test1", 0);
        Player player2 = new Player("test2", 1);
        Player player3 = new Player("test3", 2);
        Player player4 = new Player("test4", 3);
        players = new Players(Arrays.asList(player1, player2, player3, player4));
    }

    @Test
    public void 첫번째줄사다리결과() {
        Level level = Level.findLevel("middle");
        Ladder ladder = new Ladder(4, level);
        Winnings winnings = new Winnings("1, 2, 3, 4", players.size());
        LadderGame ladderGame = new LadderGame(ladder);
        Results results = ladderGame.playLadder(players, winnings);
        Result result = results.findResult("test1");
        assertThat(result).isNotNull();
    }
}