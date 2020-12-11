package step3.Controller;

import step3.domain.*;
import step3.utils.SpliterUtil;
import step3.view.InputUi;
import step3.view.OutputUi;

import java.util.List;

public class LadderGameController {

    public static void start() {

        Participants participants = Participants.of(SpliterUtil.splitNames(InputUi.nameOfParticipate()));
        Rewards rewards = Rewards.of(SpliterUtil.splitNames(InputUi.inputExecutionResult()));
        int maxHeight = InputUi.maximumHeight();
        Ladder ladder = Ladder.of(participants, maxHeight);

        OutputUi.printLadder(participants, rewards, ladder);

        String name = InputUi.wantToSeeResult();
        LadderGame ladderGame = new LadderGame(ladder.getLines(), participants, maxHeight);
        List<LadderGameResult> results = ladderGame.results(name, rewards);
        for(LadderGameResult ladderGameResult : results) {
            System.out.println(ladderGameResult.getName() +":reward ," + ladderGameResult.getReward().getName());
        }
        InputUi.close();
    }

}
