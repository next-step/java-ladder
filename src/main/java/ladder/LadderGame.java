package ladder;

import ladder.domain.Gamers;
import ladder.domain.dto.LadderResultDto;
import ladder.domain.ladder.Ladder;
import ladder.domain.ResultValues;
import ladder.ui.InputView;
import ladder.ui.OutputView;

public class LadderGame {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    private void start() {
        Gamers gamers = Gamers.of(inputView.getGamers());
        ResultValues resultValues = ResultValues.of(inputView.getLadderResults());
        Ladder ladder = Ladder.ofRandom(gamers, inputView.getHeight());

        outputView.printGamers(gamers);
        outputView.printLadder(ladder.getBarMatrix());
        outputView.printResultCandidate(resultValues);

        LadderResultDto ladderResultDto = ladder.getResult(resultValues);

        String gamer;
        while (!(gamer = inputView.getExpectResult()).equals(InputView.ALL_GAMERS)) {
            outputView.printResult(ladderResultDto.getResult(gamer));
        }
        outputView.printResultAll(gamers, ladderResultDto);
    }

    public static void main(String[] args) {
        new LadderGame().start();
    }
}
