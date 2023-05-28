package ladder;

import ladder.dto.Ladder;
import ladder.dto.Line;
import ladder.dto.Players;

import java.util.ArrayList;
import java.util.List;

import static ladder.view.InputView.getLadderHeight;
import static ladder.view.InputView.getPlayers;
import static ladder.view.ResultView.*;

public class LadderApplication {

    public static void main(String[] args) {
        Players players = getPlayers();
        Ladder ladder = new Ladder(getLadderHeight(), players);

        viewResult();
        viewPlayerNames(players);
        viewLadder(players, ladder);
    }

}
