package step3_renewal.controller;

import step3_renewal.domain.*;
import step3_renewal.utils.StringUtil;
import step3_renewal.view.InputUi;
import step3_renewal.view.OutputUi;

import static step3_renewal.domain.GameResults.results;

public class LadderGameController {

    public static void run() {
        Participants participants = Participants.of(StringUtil.splitToList(InputUi.nameOfParticipate()));
        Rewards rewards =
                Rewards.of(StringUtil.splitToList(InputUi.inputExecutionResult()), participants.getParticipants().size());

        Ladder ladder = Ladder.of(InputUi.maximumHeight(), participants,  new LadderRandomGenerator());
        OutputUi.printAll(participants, rewards, ladder);
        OutputUi.printLadderGameResult(InputUi.wantToSeeResult(), results(participants, rewards, ladder));

        InputUi.close();
    }
}
