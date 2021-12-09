package ladder.view;

import ladder.domain.ladder.Height;
import ladder.domain.ladder.Ladder;
import ladder.domain.user.Player;
import ladder.domain.user.PlayerName;
import ladder.domain.user.Players;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class ResultViewTest {

    @Test
    void printResult() {
        Player player1 = new Player(new PlayerName("pobi"));
        Player player2 = new Player(new PlayerName("honux"));
        Player player3 = new Player(new PlayerName("crong"));
        Player player4 = new Player(new PlayerName("jk"));
        Player player5 = new Player(new PlayerName("jk"));
        Players players = new Players(Arrays.asList(player1, player2, player3, player4, player5));

        Height height = new Height(4);
        Ladder ladder = Ladder.createLadder(players, height);
        ResultView.printPlayerName(players);
        ResultView.printLadder(ladder);
    }

}