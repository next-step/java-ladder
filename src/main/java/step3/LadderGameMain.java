package step3;

import step3.domain.*;
import step3.view.InputView;
import step3.view.ResultView;


public class LadderGameMain {

    private static final String GAME_END_TEXT = "all";

    public static void main(String[] args) {
        Users users = new Users(InputView.inputUsers());
        Results results = new Results(InputView.inputResults(), users.getUserCounts());
        Ladders ladders = new Ladders(InputView.inputLadderHeight(), users.getUserCounts(), new RandomLineConditional());
        ResultView.printLadderGame(users, ladders, results);
        calculateGameResult(users, ladders, results);
    }

    private static void calculateGameResult(Users users, Ladders ladders, Results results) {
        String selectedPerson;
        do {
            selectedPerson = users.findContainedName(InputView.inputSelectedPerson());
            GameResult gameResult = new GameResult(users, results, ladders);
            ResultView.printLadderGameResults(selectedPerson, gameResult);
        } while (!selectedPerson.equals(GAME_END_TEXT));
    }

}
