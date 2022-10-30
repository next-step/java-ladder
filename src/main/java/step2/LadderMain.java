package step2;

import step2.domain.Ladder;
import step2.domain.Users;
import step2.view.InputView;


public class LadderMain {
    public static void main(String[] args) {
        Users users = new Users(InputView.inputUsers());
        Ladder ladder = new Ladder(InputView.inputLadderHeight());
    }

}
