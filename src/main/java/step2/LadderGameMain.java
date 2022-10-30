package step2;

import step2.domain.Ladder;
import step2.domain.Users;
import step2.view.InputView;
import step2.view.ResultView;


public class LadderGameMain {
    public static void main(String[] args) {
        Users users = new Users(InputView.inputUsers());
        Ladder ladder = new Ladder(InputView.inputLadderHeight());
        ladder.createLadderGame(users.getUserCounts());
        ResultView.printLadderGame(users, ladder);
    }

}
