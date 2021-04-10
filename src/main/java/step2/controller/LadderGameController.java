package step2.controller;

import step2.domain.Members;
import step2.view.InputView;

public class LadderGameController {
    public void run() {
        Members members = Members.of(InputView.inputLadderGameMember());
        int membersSize = members.getSize();
        int ladderHeight = InputView.inputLadderHeight();


    }
}
