package ladder;

import ladder.domain.Gamers;
import ladder.domain.dto.LadderResultDto;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderResult;
import ladder.ui.InputView;
import ladder.ui.OutputView;

public class LadderGame {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    private void start() {
        Gamers gamers = Gamers.ofComma(inputView.getGamers());
        LadderResult ladderResult = LadderResult.ofComma(inputView.getLadderResults());
        Ladder ladder = Ladder.of(inputView.getHeight(), gamers.getGamerList().size() - 1);

        outputView.printGamers(gamers);
        outputView.printLadder(ladder);
        outputView.printResultCandidate(ladderResult);

        LadderResultDto ladderResultDto = ladder.getResult();

        String gamer;
        while (!(gamer = inputView.getExpectResult()).equals("all")) {
            outputView.printResult(ladderResultDto.getResult(gamer));
        }
        outputView.printResultAll(gamers, ladderResultDto);
    }

    public static void main(String[] args) {
        new LadderGame().start();
    }
}
