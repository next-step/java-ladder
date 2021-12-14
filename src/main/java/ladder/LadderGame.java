package ladder;

import ladder.domain.Ladder;
import ladder.domain.Participants;
import ladder.strategy.MovingStrategy;
import ladder.strategy.RandomMovingStrategy;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGame {
    public static void play() {
        InputView inputView = new InputView();
        Participants participants = inputView.getNames();
        int height = inputView.getLadderHeight();

        MovingStrategy movingStrategy = new RandomMovingStrategy();
        Ladder ladder = new Ladder(height, participants.size(), movingStrategy);

        ResultView resultView = new ResultView();
        resultView.printNames(participants.getParticipantNames());
        resultView.printLadder(ladder);
    }
}
