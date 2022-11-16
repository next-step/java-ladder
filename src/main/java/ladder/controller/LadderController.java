package ladder.controller;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Participants;
import ladder.util.LadderUtil;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {
    public void run() {
        String[] names = InputView.participantsScan();
        Participants participants = new Participants(LadderUtil.CastingArrayToList(names));
        Height height = new Height(InputView.heightScan());
        Ladder ladder = new Ladder(participants.countOfMember(), height);
        ResultView.printLadderResult(participants, ladder);
    }
}
