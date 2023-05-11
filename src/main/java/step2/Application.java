package step2;

import step2.domain.Height;
import step2.domain.Ladder;
import step2.domain.Users;
import step2.view.InputView;
import step2.view.ResultView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        Users users = inputView.inputUser();
        Height height = inputView.inputLadderHeight();

        Ladder ladder = new Ladder(users.getUsers().size(), height.getHight());
        ResultView.printLadder(ladder, users);
    }
}

