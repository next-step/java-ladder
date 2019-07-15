package ladder.controller;

import ladder.domain.Ladder2;
import ladder.domain.Ladder2Result;
import ladder.domain.Names;
import ladder.domain.Rewards;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Main {
    public static void main(String[] args) {
        String nameString = InputView.getParticipantInput();
        String rewardString = InputView.getRewardsInput();
        int ladderHeight = InputView.getLadderHeightInput();

        Names names = Names.of(nameString);
        Rewards rewards = Rewards.of(rewardString);

        Ladder2 ladder = Ladder2.of(ladderHeight, names.size());
        Ladder2Result ladderResult = new Ladder2Result(ladder, names);

        ResultView.printDefaultSummary2(names, ladder, rewards, ladderResult);

        /* step3 까지 내가 만들었던 코드로 동작하기
        RandomLineGenerator randomLineGenerator = new RandomLineGenerator(names.size());
        Ladder ladder = Ladder.of(randomLineGenerator, ladderHeight);
        LadderResult ladderResult = new LadderResult(ladder, names);

        ResultView.printDefaultSummary(names, ladder, rewards, ladderResult);
         */
    }
}
