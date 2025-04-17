package nextstep.ladder.controller;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Players;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGameController {

    public void run() {
        String inputNames = InputView.inputPlayerNames();
        int height = InputView.inputLadderHeight();

        Players players = new Players(inputNames);
        Ladder ladder = new Ladder(height, players.size());

        ResultView.printPlayers(players);
        ResultView.printLadder(ladder);
    }

    public static void main(String[] args) {
        new LadderGameController().run();
    }
}
