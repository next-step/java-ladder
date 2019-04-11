package view;

import domain.ladder.Goals;
import domain.ladder.Ladder;
import domain.user.Users;
import domain.bridge.BridgeRandomGenerator;

public class ConsoleMain {
    public static void main(String[] args) {
        String names = InputView.inputUsers();
        String result = InputView.inputGoals();
        int ladderHeight = InputView.inputLadderHeight();

        Users users = new Users(names);
        Ladder ladder = new Ladder(ladderHeight, users.size(), new BridgeRandomGenerator());
        Goals goals = new Goals(result);

        ResultView.result(users, ladder, goals);
    }
}
