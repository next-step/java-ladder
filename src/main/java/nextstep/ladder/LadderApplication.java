package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Names;
import nextstep.ladder.domain.RandomConnector;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderApplication {
    public static void main(String[] args) {
        String names = InputView.inputNames();
        Names gamers = Names.of(names);

        int height = InputView.inputLadderHeight();
        Ladder ladder = Ladder.ofHeightAndCountOfPerson(height, gamers.size(), new RandomConnector());

        ResultView.printNames(gamers.toDto());
        ResultView.printLadder(ladder.toDto());
    }
}
