package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderHeight;
import ladder.domain.LadderMembers;

import static ladder.view.InputView.askMaxLadderHeight;
import static ladder.view.InputView.askParticipatedPeople;
import static ladder.view.ResultView.printLadderResult;

public class LadderApplication {
    public static void main(String[] args) {
        LadderMembers members = new LadderMembers(askParticipatedPeople());
        LadderHeight ladderHeight = new LadderHeight(askMaxLadderHeight());
        Ladder ladder = new Ladder(members.memberCount(), ladderHeight);
        printLadderResult(members, ladder);
    }
}
