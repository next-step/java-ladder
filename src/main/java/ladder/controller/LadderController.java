package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.LadderHeight;
import ladder.domain.LadderMembers;

import java.util.List;

import static ladder.view.InputView.askMaxLadderHeight;
import static ladder.view.InputView.askParticipatedPeople;
import static ladder.view.ResultView.printLadderResult;

public class LadderController {

    private LadderController() {
    }

    public static void play() {
        List<String> memberNames = askParticipatedPeople();
        LadderMembers members = new LadderMembers(LadderMembers.addMember(memberNames));
        LadderHeight ladderHeight = new LadderHeight(askMaxLadderHeight());
        Ladder ladder = new Ladder(members.memberCount(), ladderHeight);
        printLadderResult(members, ladder);
    }
}
