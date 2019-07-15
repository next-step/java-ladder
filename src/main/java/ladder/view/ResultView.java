package ladder.view;

import ladder.domain.*;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    public static final String LINE_EXIST_TEXT;
    public static final String LINE_NOT_EXIST_TEXT;

    static {
        String existText = "";
        String notExistText = "";
        for (int i = 0; i < Name.MAX_NAME_LENGTH; i++) {
            existText += "-";
            notExistText += " ";
        }
        LINE_EXIST_TEXT = existText;
        LINE_NOT_EXIST_TEXT = notExistText;
    }

    public static void printDefaultSummary(Names names, Ladder ladder, Rewards rewards, LadderResult ladderResult) {
        printLadderResultText();
        printNamesText(names);
        printLadderText(ladder);
        printRewardsText(rewards);

        printSeparateResult(names, rewards, ladderResult);
    }

    public static void printDefaultSummary2(Names names, Ladder2 ladder, Rewards rewards, Ladder2Result ladderResult) {
        printLadderResultText();
        printNamesText(names);
        printLadder2Text(ladder);
        printRewardsText(rewards);

        printSeparateResult2(names, rewards, ladderResult);
    }

    private static void printSeparateResult(Names names, Rewards rewards, LadderResult ladderResult) {
        String nameToShow = InputView.getResultNameInput();
        while (!"all".equals(nameToShow)) {
            int resultIndex = ladderResult.resultOf(nameToShow);
            ResultView.printRewardText(rewards, resultIndex);

            nameToShow = InputView.getResultNameInput();
        }
        int resultIndex = ladderResult.resultOf(nameToShow);
        ResultView.printRewardText(rewards, resultIndex);

        ResultView.printNameAndResultText(names, rewards, ladderResult);
    }

    private static void printSeparateResult2(Names names, Rewards rewards, Ladder2Result ladderResult) {
        String nameToShow = InputView.getResultNameInput();
        while (!"all".equals(nameToShow)) {
            int resultIndex = ladderResult.resultOf(nameToShow);
            ResultView.printRewardText(rewards, resultIndex);

            nameToShow = InputView.getResultNameInput();
        }
        int resultIndex = ladderResult.resultOf(nameToShow);
        ResultView.printRewardText(rewards, resultIndex);

        ResultView.printNameAndResultText2(names, rewards, ladderResult);
    }

    private static void printLadderResultText() {
        System.out.println("\n사다리 결과\n");
    }

    private static void printRewardText(Rewards rewards, int index) {
        System.out.println("\n실행 결과\n" +
                rewards.get(index));
    }

    private static void printNamesText(Names names) {
        System.out.println(names.getNames().stream()
                .map(Name::getViewName).collect(Collectors.joining(" ")));
    }

    private static void printRewardsText(Rewards rewards) {
        System.out.println(rewards.getRewards().stream()
                .map(Reward::getViewName).collect(Collectors.joining(" ")));
    }

    public static void printLadderText(Ladder ladder) {

        String result = "";
        for (int i = 0; i < ladder.height(); i++) {
            result += ladder.linesByLevel(i).getLines()
                    .stream()
                    .map(horizontalLine -> horizontalLine.hasLine() ? LINE_EXIST_TEXT : LINE_NOT_EXIST_TEXT)
                    .collect(Collectors.joining("|"));
            result += "|\n";
        }
        System.out.println(result);
    }

    private static void printLadder2Text(Ladder2 ladder) {
        System.out.println(IntStream.range(0, ladder.height())
                .mapToObj(level -> ladder.getLadderLineByLevel(level).getPoints())
                .map(points -> points.stream().map(Point::hasLeft)
                        .map(hasLeft -> hasLeft ? LINE_EXIST_TEXT : LINE_NOT_EXIST_TEXT)
                        .collect(Collectors.joining("|")))
                .collect(Collectors.joining("|\n"))
                + "|\n");
    }

    public static void printNameAndResultText(Names names, Rewards rewards, LadderResult ladderResult) {
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

    private static void printNameAndResultText2(Names names, Rewards rewards, Ladder2Result ladderResult) {
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
