package view;

import domain.ladder.Ladder;
import domain.user.Users;

public class ConsoleMain {
    public static void main(String[] args) {
        String names = InputView.inputUsers();
        int ladderHeight = InputView.inputLadderHeight();

        Users users = new Users(names);
        Ladder ladder = new Ladder(ladderHeight, users.size());

        ResultView.result(users, ladder);
    }
}
