package ladder;

import ladder.domain.Ladder;
import ladder.domain.Users;

import static ladder.view.InputView.askLadderHeight;
import static ladder.view.InputView.askUserName;
import static ladder.view.ResultView.*;

public class LadderApplication {
    public static void main(String[] args) {
        String[] usersName = askUserName();
        Users users = new Users(usersName);

        int ladderHeight = askLadderHeight();
        Ladder ladder = new Ladder(ladderHeight, usersName.length);

        printUserList(users);
        printLadder(ladder);
    }

}
