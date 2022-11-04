package ladder;

import ladder.ladder.Ladder;
import ladder.ladder.LadderGenerator;
import ladder.ladder.RowGenerator;
import ladder.result.Awards;
import ladder.user.Players;
import ladder.user.UserNames;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderApplication {

    public static void main(String[] args) {
        UserNames userNames = InputView.inputUserName();
        Awards awards = InputView.inputGameAwards();
        int ladderHeight = InputView.inputLadderHeight();

        LadderGenerator ladderGenerator = new LadderGenerator(new RowGenerator());
        Ladder ladder = ladderGenerator.create(userNames.size(), ladderHeight);

        ResultView.printResult(userNames, ladder, ladder.play(new Players(userNames), awards));
    }
}
