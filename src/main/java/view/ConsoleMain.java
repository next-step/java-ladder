package view;

import domain.ladder.Ladder;
import domain.user.Users;
import util.BridgeRandomGenerator;

public class ConsoleMain {
    public static void main(String[] args) {
        String names = InputView.inputUsers();
        int ladderHeight = InputView.inputLadderHeight();

        Users users = new Users(names);

        Ladder ladder = new Ladder(ladderHeight, users.size(), new BridgeRandomGenerator());

        ResultView.result(users, ladder);
    }
}
