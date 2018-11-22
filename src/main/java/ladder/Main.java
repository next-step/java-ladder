package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.domain.People;
import ladder.domain.Result;
import ladder.view.ResultView;

import static ladder.view.InputView.getLadderHeight;
import static ladder.view.InputView.getPersonNames;
import static ladder.view.InputView.getResultReward;

public class Main {
    public static void main(String[] args) {
        People people= People.from(getPersonNames());
        Ladder ladder = Ladder.from(getLadderHeight());
        LadderGame ladderGame = LadderGame.from(people, ladder);

        Result result = Result.from(getResultReward());

        ResultView.printLadder(ladderGame, result);
    }
}
