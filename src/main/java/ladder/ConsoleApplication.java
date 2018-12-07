package ladder;

import ladder.model.LadderGame;
import ladder.model.LadderResult;

import static ladder.ui.console.InputView.inputLadderLevel;
import static ladder.ui.console.InputView.inputNames;
import static ladder.ui.console.InputView.inputResultPerson;
import static ladder.ui.console.InputView.inputReward;
import static ladder.ui.console.ResultView.ladderResult;
import static ladder.ui.console.ResultView.showLadder;

public class ConsoleApplication {
    public static void main(String[] args) {
        String names = inputNames();
        String level = inputLadderLevel();

        String reward = inputReward();

        LadderGame ladderGame = LadderGame.of(names, reward, level);
        LadderResult result = ladderGame.result();

        showLadder(ladderGame);

        while(true) {
            String person = inputResultPerson();
            ladderResult(result, person);

            if(person.equals("all")) break;
        }
    }
}
