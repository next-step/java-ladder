package ladder.controller;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Game {

    public void play() {
        String inputPlayers = InputView.questionPlayers();
        Players players = Players.of(inputPlayers);

        String height = InputView.questionHeight();
        Height ladderHeight = Height.of(height);

        Ladder ladder = Ladder.of(ladderHeight, players);
        result(players, ladder);
    }

    public void result(Players players, Ladder ladder) {
        ResultView.printResult();
        ResultView.printPlayers(players);
        ResultView.printLadder(ladder);
    }
}
