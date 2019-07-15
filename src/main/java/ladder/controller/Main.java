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

        System.out.println(ResultView.getDefaultResultText());
        System.out.println(ResultView.getNamesView(names));
        System.out.println(ResultView.getLadder2View(ladder));
        System.out.println(ResultView.getRewardsView(rewards));

        String nameToShow = InputView.getResultNameInput();
        while (!"all".equals(nameToShow)) {
            int resultIndex = ladderResult.resultOf(nameToShow);
            System.out.println(ResultView.getRewardText(rewards, resultIndex));

            nameToShow = InputView.getResultNameInput();
        }
        int resultIndex = ladderResult.resultOf(nameToShow);
        System.out.println(ResultView.getRewardText(rewards, resultIndex));

        System.out.println(ResultView.getNameAndResultView2(names, rewards, ladderResult));

        /* 내가 Step3 까지 만들었던 로직의 실행부
        RandomLineGenerator randomLineGenerator = new RandomLineGenerator(names.size());
        Ladder ladder = Ladder.of(randomLineGenerator, ladderHeight);
        LadderResult ladderResult = new LadderResult(ladder, names);

        System.out.println(ResultView.getDefaultResultText());
        System.out.println(ResultView.getNamesView(names));
        System.out.println(ResultView.getLadderView(ladder));
        System.out.println(ResultView.getRewardsView(rewards));

        System.out.println(InputView.getResultNameInputText());
        String nameToShow = scanner.nextLine();
        while (!"all".equals(nameToShow) {
            int resultIndex = ladderResult.resultOf(nameToShow);
            System.out.println(ResultView.getRewardText(rewards, resultIndex));

            System.out.println(InputView.getResultNameInputText());
            nameToShow = scanner.nextLine();
        }
        int resultIndex = ladderResult.resultOf(nameToShow);
        System.out.println(ResultView.getRewardText(rewards, resultIndex));

        System.out.println(ResultView.getNameAndResultView(names, rewards, ladderResult));
         */
    }
}
