package ladder.service;

import ladder.domain.LadderHeight;
import ladder.domain.Users;
import ladder.view.InputView;

public class LadderService {
    private Users users;
    private LadderHeight ladderHeight;

    public void createUsers() {
        users = InputView.inputUserName();
        System.out.println();
    }

    public void createLadderHeight() {
        ladderHeight = InputView.inputLadderHeight();
        System.out.println(ladderHeight);
    }
}
