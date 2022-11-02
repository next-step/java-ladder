package step3;

import step3.domain.*;
import step3.view.InputView;
import step3.view.ResultView;


public class LadderGameMain {
    public static void main(String[] args) {
        Users users = new Users(InputView.inputUsers());
        Results results = new Results(InputView.inputResults(), users.getUserCounts());
        Ladder ladder = new Ladder(InputView.inputLadderHeight(), users.getUserCounts(), new RandomLineConditional());
        ResultView.printLadderGame(users, ladder, results);
        String selectedPerson = users.findContainedName(InputView.inputSelectedPerson());
        GameResult gameResult = new GameResult(selectedPerson, users, ladder);
    }

}
