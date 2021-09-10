package nextstep.laddergame;

import nextstep.laddergame.domain.*;
import nextstep.laddergame.view.InputView;
import nextstep.laddergame.view.OutputView;

import java.util.Map;

public class LadderGame {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Players players = inputPlayers();
        PlayResults playResults = inputPlayResults(players.size());
        LadderHeights ladderHeights = inputLadderHeights();
        Ladder ladder = Ladder.of(players, ladderHeights);
        outputView.printLadder(players, ladder, playResults);
        Map<PlayerName, String> ladderResults = ladder.getResults(players, playResults);
        while (true) {
            outputView.printResultCheckInputMessage();
            outputView.printPlayResult(ladderResults, inputView.getPlayerName());
        }
    }

    private Players inputPlayers() {
        outputView.printPlayersNameInputMessage();
        return Players.of(inputView.getListInputs());
    }

    private PlayResults inputPlayResults(int requiredResultCount) {
        outputView.printPlayResultsInputMessage();
        return PlayResults.with(requiredResultCount, inputView.getListInputs());
    }

    private LadderHeights inputLadderHeights() {
        outputView.printLadderHeightsInputMessage();
        return LadderHeights.of(inputView.getLadderHeights());
    }

    public static void main(String[] args) {
        InputView inputView = InputView.of(System.in);
        OutputView outputView = OutputView.of(System.out);
        LadderGame ladderGame = new LadderGame(inputView, outputView);
        ladderGame.run();
    }
}
