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

    public static String getDefaultResultText() {
        return "\n사다리 결과\n";
    }

    public static String getRewardText(Rewards rewards, int index) {
        return "\n실행 결과\n" +
                rewards.get(index);
    }

    public static String getNamesView(Names names) {
        return names.getNames().stream()
                .map(Name::getViewName).collect(Collectors.joining(" "));
    }

    public static String getRewardsView(Rewards rewards) {
        return rewards.getRewards().stream()
                .map(Reward::getViewName).collect(Collectors.joining(" "));
    }

    public static String getLadderView(Ladder ladder) {

        String result = "";
        for (int i = 0; i < ladder.height(); i++) {
            result += ladder.linesByLevel(i).getLines()
                    .stream()
                    .map(horizontalLine -> horizontalLine.hasLine() ? LINE_EXIST_TEXT : LINE_NOT_EXIST_TEXT)
                    .collect(Collectors.joining("|"));
            result += "|\n";
        }
        return result;
    }

    public static String getLadder2View(Ladder2 ladder) {
        return IntStream.range(0, ladder.height())
                .mapToObj(level -> ladder.getLadderLineByLevel(level).getPoints())
                .map(points -> points.stream().map(Point::hasLeft)
                        .map(hasLeft -> hasLeft ? LINE_EXIST_TEXT : LINE_NOT_EXIST_TEXT)
                        .collect(Collectors.joining("|")))
                .collect(Collectors.joining("|\n"));
    }

    public static String getNameAndResultView(Names names, Rewards rewards, LadderResult ladderResult) {
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(0, names.size())
                .forEach(index -> {
                    stringBuilder.append(names.get(index).getName());
                    stringBuilder.append(StringUtils.VIEW_BETWEEN_NAME_RESULT);
                    stringBuilder.append(rewards.get(ladderResult.result(index)));
                    stringBuilder.append("\n");
                });
        return stringBuilder.toString();
    }

    public static String getNameAndResultView2(Names names, Rewards rewards, Ladder2Result ladderResult) {
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(0, names.size())
                .forEach(index -> {
                    stringBuilder.append(names.get(index).getName());
                    stringBuilder.append(StringUtils.VIEW_BETWEEN_NAME_RESULT);
                    stringBuilder.append(rewards.get(ladderResult.result(index)));
                    stringBuilder.append("\n");
                });
        return stringBuilder.toString();
    }
}
