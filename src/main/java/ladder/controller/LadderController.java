package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.LadderHeight;
import ladder.domain.LadderMembers;
import ladder.domain.LadderResults;
import ladder.dto.LadderDto;
import ladder.dto.MembersDto;

import java.util.List;

import static ladder.view.InputView.*;
import static ladder.view.ResultView.printLadderResult;

public class LadderController {

    private LadderController() {
    }

    public static void play() {
        List<String> memberNames = askParticipatedPeople();
        int memberCount = memberNames.size();
        LadderMembers members = new LadderMembers(LadderMembers.addMember(memberNames));
        List<String> ladderResults = askLadderResult();
        LadderResults results = new LadderResults(LadderResults.addResult(ladderResults, memberCount));
        LadderHeight ladderHeight = new LadderHeight(askMaxLadderHeight());
        Ladder ladder = new Ladder(memberCount, ladderHeight);
        printLadderResult(new MembersDto(members), new LadderDto(ladder));
    }
}
