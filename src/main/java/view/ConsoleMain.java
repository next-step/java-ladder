package view;

import domain.LadderGame;
import domain.bridge.BridgeRandomGenerator;
import domain.ladder.Goals;
import domain.ladder.Ladder;
import domain.result.Results;
import domain.user.Users;

public class ConsoleMain {
    public static void main(String[] args) {
        String names = InputView.inputUsers();
        String result = InputView.inputGoals();
        int ladderHeight = InputView.inputLadderHeight();

        Users users = new Users(names);
        Ladder ladder = new Ladder(ladderHeight, users.size(), new BridgeRandomGenerator());
        Goals goals = new Goals(result);
        ResultView.ladder(users, ladder, goals);

        String resultUser = InputView.inputResultUser();
        LadderGame ladderGame = new LadderGame(ladder, users);
        Results results = ladderGame.result(resultUser, goals);
        ResultView.result(resultUser, users, results);
    }
}
