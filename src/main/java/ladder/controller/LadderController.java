package ladder.controller;

import ladder.domain.Height;
import ladder.domain.Participants;
import ladder.util.LadderUtil;
import ladder.view.InputView;

import java.util.List;

public class LadderController {
    public void run() {
        String[] names = InputView.participantsScan();
        Participants participants = new Participants(LadderUtil.CastingArrayToList(names));

        Height height = new Height(InputView.heightScan());

    }
}
