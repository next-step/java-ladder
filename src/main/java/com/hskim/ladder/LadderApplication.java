package com.hskim.ladder;

import com.hskim.ladder.model.LadderUsers;
import com.hskim.ladder.model.User;
import com.hskim.ladder.model.UserName;
import com.hskim.ladder.ui.LadderInputView;

import java.util.List;

public class LadderApplication {

    public static void main(String[] args) {
        LadderInputView ladderInputView = new LadderInputView();

        ladderInputView.printParticipantsPhrase();
        List<UserName> userNames = UserName.makeUserNamesFromNames(ladderInputView.getUserNames());
        LadderUsers ladderUsers = new LadderUsers(User.makeUsersFromNames(userNames));
    }
}
