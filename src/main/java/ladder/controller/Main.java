package ladder.controller;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(InputView.getParticipantInputText());
        String nameString = scanner.nextLine();

        System.out.println(InputView.getRewardsInputText());
        String rewardString = scanner.nextLine();

        System.out.println(InputView.getLadderHeightInputText());
        int ladderHeight = scanner.nextInt();
        scanner.nextLine();

        Names names = Names.of(nameString);
        RandomLineGenerator randomLineGenerator = new RandomLineGenerator(names.size());
        Rewards rewards = Rewards.of(rewardString);
        Ladder ladder = Ladder.of(randomLineGenerator, ladderHeight);
        LadderResult ladderResult = new LadderResult(ladder, names);

        System.out.println(ResultView.getDefaultResultText());
        System.out.println(ResultView.getNamesView(names));
        System.out.println(ResultView.getLadderView(ladder));

        String nameToShow = "";
        while (!nameToShow.equals("all")) {
            System.out.println(InputView.getResultNameInputText());
            nameToShow = scanner.nextLine();
            int resultIndex = ladderResult.resultOf(nameToShow);

            System.out.println(ResultView.getDefaultRewardText());
            System.out.println(rewards.get(resultIndex).getName());
        }
    }
}
