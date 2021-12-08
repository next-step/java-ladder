package ladder.view;

import ladder.domain.*;
import ladder.domain.PlayerName;
import ladder.domain.Position;
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
        Ladder ladder = LadderGenerator.createLadder(players, height);

        ResultView.printLadder(players, height);
    }

}