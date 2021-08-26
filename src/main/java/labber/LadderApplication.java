package labber;

import labber.domain.Ladder;
import labber.domain.Users;

import static labber.view.InputView.askLadderHeight;
import static labber.view.InputView.askUserName;
import static labber.view.ResultView.printResult;

public class LadderApplication {
    public static void main(String[] args) {
        String[] usersName = askUserName();
        Users users = new Users(usersName);

        int ladderHeight = askLadderHeight();
        Ladder ladder = new Ladder(ladderHeight, usersName.length);

        printResult(users, ladder);
    }

}
