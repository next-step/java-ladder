package ladder;

import ladder.domain.*;
import ladder.service.LadderGame;

import static ladder.view.InputView.*;
import static ladder.view.ResultView.*;

public class LadderApplication {

    public static void main(String[] args) {
        Players players = getPlayers();
        Ladder ladder = new Ladder(getLadderHeight(), players);
        Results results = getResults(players);

        LadderGame ladderGame = new LadderGame();
        PlayerResults playerResults = ladderGame.makePlayResults(players, ladder, results);

        viewResult(players, ladder, results);
        viewPlayerResult(playerResults, getResultOfPlayer(players));
    }

}
