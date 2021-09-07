package nextstep.laddergame;

import nextstep.laddergame.domain.Ladder;
import nextstep.laddergame.domain.LadderHeights;
import nextstep.laddergame.domain.PlayResults;
import nextstep.laddergame.domain.Players;
import nextstep.laddergame.view.InputView;
import nextstep.laddergame.view.OutputView;

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
        return inputView.getLadderHeights();
    }

    public static void main(String[] args) {
        InputView inputView = InputView.of(System.in);
        OutputView outputView = OutputView.of(System.out);
        LadderGame ladderGame = new LadderGame(inputView, outputView);
        ladderGame.run();
    }
}
