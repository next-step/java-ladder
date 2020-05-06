package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Users users = InputView.askNumberOfUser();
        LadderGoals ladderGoals = InputView.askLadderGoals();

        Ladder ladder = new Ladder(InputView.askLadderHeight(), new DirectionGenerator(users.size()));
        OutputView.printLadders(users, ladder, ladderGoals);

        LadderResult ladderResult = new LadderResult(ladder.play(users, ladderGoals));
        OutputView.printGameResult(ladderResult);
    }
}
