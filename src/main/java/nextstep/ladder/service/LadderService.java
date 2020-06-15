package nextstep.ladder.service;

import nextstep.ladder.domain.line.Lines;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderService {
    private Players players;
    private Lines lines;

    public void initLadderGame() {
        players = new Players(InputView.scanPlayerNames());
        lines = new Lines(players.getPlayerCount(), InputView.scanLadderHeight());
    }

    public void printLadder() {
        ResultView.printResult(players, lines);
    }
}
