package nextstep.laddergame;

import nextstep.laddergame.domain.*;
import nextstep.laddergame.view.InputView;
import nextstep.laddergame.view.OutputView;

import java.util.List;

public class LadderGame {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Players players = inputPlayers();
        Ladder ladder = createLadder(players.getPlayerCount());
        outputView.printLadder(players, ladder);
    }

    private Players inputPlayers() {
        outputView.printPlayersNameInputMessage();
        List<PlayerName> playerNames = inputView.getPlayerNames();
        return Players.of(playerNames);
    }

    private Ladder createLadder(PlayerCount playerCount) {
        outputView.printLadderHeightsInputMessage();
        LadderHeights ladderHeights = inputView.getLadderHeights();
        return Ladder.of(playerCount, ladderHeights);
    }

    public static void main(String[] args) {
        InputView inputView = InputView.of(System.in);
        OutputView outputView = OutputView.of(System.out);
        LadderGame ladderGame = new LadderGame(inputView, outputView);
        ladderGame.run();
    }
}
