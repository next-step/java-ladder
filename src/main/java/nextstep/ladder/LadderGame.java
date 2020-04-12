package nextstep.ladder;

import nextstep.ladder.domain.gamer.Gamers;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.result.Results;
import nextstep.ladder.service.LadderGameService;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.OutputView;

public class LadderGame {
    private final InputView inputView;
    private final OutputView outputView;

    public LadderGame() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void start() {
        Gamers gamers = Gamers.of(inputView.getGamers());
        Results results = Results.of(inputView.getLadderResults());
        Ladder ladder = Ladder.of(gamers.size(), inputView.getHeight());

        outputView.printGamers(gamers);
        outputView.printLadder(ladder);
        outputView.printResultCandidate(results);

        LadderGameService ladderGameService = LadderGameService.of(gamers, results, ladder);

        String gamer;
        while (!(gamer = inputView.getExpectResult()).equals(InputView.ALL_GAMERS)) {
            outputView.printResult(ladderGameService.getResult(gamer));
        }
        outputView.printResultAll(gamers, ladderGameService);
    }

    public static void main(String[] args) {
        new LadderGame().start();
    }
}
