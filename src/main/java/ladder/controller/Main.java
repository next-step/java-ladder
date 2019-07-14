package ladder.controller;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.Scanner;
import java.util.stream.IntStream;

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
        System.out.println(ResultView.getRewardsView(rewards));

        String nameToShow = "";
        while (!nameToShow.equals("all")) {
            System.out.println(InputView.getResultNameInputText());
            nameToShow = scanner.nextLine();
            int resultIndex = ladderResult.resultOf(nameToShow);

            System.out.println(ResultView.getDefaultRewardText());
            System.out.println(rewards.get(resultIndex));
        }

        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(0, names.size())
                .forEach(index -> {
                    stringBuilder.append(names.get(index).getName());
                    stringBuilder.append(StringUtils.VIEW_BETWEEN_NAME_RESULT);
                    stringBuilder.append(rewards.get(ladderResult.result(index)));
                    stringBuilder.append("\n");
                });
        System.out.println(stringBuilder.toString());
    }
}
