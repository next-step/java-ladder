package com.hskim.ladder;

import com.hskim.ladder.model.Ladder;
import com.hskim.ladder.model.LadderHeight;
import com.hskim.ladder.model.LadderUsers;
import com.hskim.ladder.model.Line;
import com.hskim.ladder.model.Lines;
import com.hskim.ladder.model.RandomRowIndexMaker;
import com.hskim.ladder.model.User;
import com.hskim.ladder.model.UserName;
import com.hskim.ladder.ui.LadderInputView;
import com.hskim.ladder.ui.LadderResultView;

import java.util.List;

public class LadderApplication {

    public static void main(String[] args) {
        LadderInputView ladderInputView = new LadderInputView();
        LadderResultView ladderResultView = new LadderResultView();

        ladderInputView.printParticipantsPhrase();
        List<UserName> userNames = UserName.makeUserNamesFromNames(ladderInputView.getUserNames());
        LadderUsers ladderUsers = new LadderUsers(User.makeUsersFromNames(userNames));

        ladderInputView.printLadderHeightPhrase();
        LadderHeight ladderHeight = new LadderHeight(ladderInputView.getLadderHeight());
        Lines lines = Lines.of(ladderHeight.getLineNum(),
                ladderUsers.getUserNumber(), new RandomRowIndexMaker());
        Ladder ladder = new Ladder(ladderHeight, ladderUsers, lines);

        ladderResultView.printResultPhrase();
        ladderResultView.printUserNames(ladderUsers.getUserNames());
        ladderResultView.printLines(ladder.getAllPoints());
    }
}
