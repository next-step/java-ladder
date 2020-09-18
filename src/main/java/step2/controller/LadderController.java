package step2.controller;

import step2.domain.Ladder;
import step2.domain.UserList;
import step2.view.InputView;
import step2.view.RenderView;

public class LadderController {

    public static void execute() {
        String participantsNames = InputView.inputParticipantsName();

        UserList userList = UserList.create(participantsNames);

        int inputLadderDepth = InputView.inputLadderDepth();

        Ladder ladder = Ladder.create(inputLadderDepth, userList.getTotalParticipantsCount());

        System.out.println("실행결과");

        RenderView.renderUserNameList(userList);
        RenderView.renderLadder(ladder);
    }
}


