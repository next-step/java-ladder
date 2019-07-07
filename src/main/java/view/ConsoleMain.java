package view;

import domain.LadderGame;
import domain.bridge.BridgeRandomGenerator;
import domain.ladder.Complexity;
import domain.ladder.Goals;
import domain.ladder.Ladder;
import domain.result.Results;
import domain.user.Users;

public class ConsoleMain {
    private static final String RESULT_ALL = "all";

    public static void main(String[] args) {
        String names = InputView.inputUsers();
        String result = InputView.inputGoals();
        String level = InputView.inputLevel();
        int ladderHeight = Complexity.determineHeight(level);

        Users users = new Users(names);
        Ladder ladder = new Ladder(ladderHeight, users.size()
                , new BridgeRandomGenerator(Complexity.determineBridgeComplexity(level)));
        Goals goals = new Goals(result);
        ResultView.ladder(users, ladder, goals);

        LadderGame ladderGame = new LadderGame(ladder, users);
        checkResult(users, goals, ladderGame);
    }

    private static void checkResult(Users users, Goals goals, LadderGame ladderGame) {
        String resultUser = "";
        do {
            resultUser = InputView.inputResultUser();
            Results results = ladderGame.result(resultUser, goals);
            ResultView.result(resultUser, users, results);
        } while (!RESULT_ALL.equals(resultUser));
    }
}