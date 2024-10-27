package nextstep.ladder.domain;

import nextstep.ladder.model.Gamers;
import nextstep.ladder.model.Ladder;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGame {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();
    public void start() {
        Gamers gamers = new Gamers(inputView.receiveGamers());
        int height = inputView.receiveMaxHeight();
        Ladder ladder = new Ladder(height, gamers.getCountOfPerson());
        resultView.printResult(gamers, ladder);
    }
}
