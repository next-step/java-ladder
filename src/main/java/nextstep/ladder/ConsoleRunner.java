package nextstep.ladder;

import nextstep.ladder.domain.endpoint.Endpoints;
import nextstep.ladder.domain.laddar.LadderGame;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.domain.view.InputView;
import nextstep.ladder.domain.view.ResultView;

public class ConsoleRunner {
    public static void main(String[] args) {
        final String playerNames = InputView.playerNames();
        ResultView.newLine();

        final String endpoints = InputView.endpoints();
        ResultView.newLine();

        final int ladderHeight = InputView.ladderHeight();
        ResultView.newLine();

        final Players players = Players.from(playerNames);
        LadderGame ladderGame = LadderGame.initialize(players, ladderHeight, Endpoints.from(endpoints));

        ResultView.printResultAll(players, ladderGame.getGameResult());
    }
}
