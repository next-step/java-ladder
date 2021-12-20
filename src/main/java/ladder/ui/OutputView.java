package ladder.ui;

import ladder.domain.*;
import ladder.dto.LadderGameDto;
import ladder.enums.LadderPart;
import ladder.util.function.MathFunction;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String LADDER_RESULT_MESSAGE = "사다리 결과";
    private static final String REWARD_RESULT_MESSAGE = "실행 결과";
    private static final int NAME_PADDING = 6;
    private static final char SPACE = ' ';
    private static final String TWO_SPACE = "  ";
    private static final String LINE_JOINING_DELIMITER = "\n" + TWO_SPACE;
    private static final String EMPTY_DELIMITER = "";
    private static final StringBuilder STRING_BUILDER = new StringBuilder();
    private static final int STRING_BUILDER_DEFAULT_LENGTH = 0;
    private static final String RAIL_VALUE = "|";
    private static final String RUNG_VALUE = "-----";
    private static final String EMPTY_RUNG_VALUE = "     ";
    private static final String PRINT_ALL_FORMAT = "%s : %s\n";

    private OutputView() {}

    public static void printLadderGame(LadderGameDto ladderGame) {
        enter();
        System.out.println(LADDER_RESULT_MESSAGE);
        enter();
        printNames(ladderGame.getNames());
        printLadders(ladderGame.getLadder());
        printRewards(ladderGame.getRewards());
    }

    private static void printNames(LadderStrings<Name> names) {
        List<Name> nameList = names.getValue();
        System.out.println(nameList.stream()
                .map(Name::getValue)
                .map(OutputView::padding)
                .collect(Collectors.joining(EMPTY_DELIMITER)));
    }

    private static String padding(String name) {
        STRING_BUILDER.setLength(STRING_BUILDER_DEFAULT_LENGTH);
        STRING_BUILDER.append(name);
        while (STRING_BUILDER.length() < NAME_PADDING) {
            append();
        }
        return STRING_BUILDER.toString();
    }

    private static void append() {
        if (MathFunction.EVEN_NUMBER.test(STRING_BUILDER.length())) {
            STRING_BUILDER.append(SPACE);
            return;
        }

        STRING_BUILDER.insert(STRING_BUILDER_DEFAULT_LENGTH, SPACE);
    }

    private static void printLadders(Ladder ladder) {
        STRING_BUILDER.setLength(STRING_BUILDER_DEFAULT_LENGTH);
        List<Line> lines = ladder.getLines();
        STRING_BUILDER.append(TWO_SPACE);
        STRING_BUILDER.append(lines.stream()
                .map(OutputView::appendLine)
                .collect(Collectors.joining(LINE_JOINING_DELIMITER)));
        System.out.println(STRING_BUILDER);
    }

    private static String appendLine(Line line) {
        List<LadderPart> ladderParts = line.getLadderParts();
        return ladderParts.stream()
                .map(OutputView::ladderPartValue)
                .collect(Collectors.joining(EMPTY_DELIMITER));
    }

    private static String ladderPartValue(LadderPart ladderPart) {
        if (ladderPart.isRail()) {
            return RAIL_VALUE;
        }

        if (ladderPart.isRung()) {
            return RUNG_VALUE;
        }

        return EMPTY_RUNG_VALUE;
    }

    private static void printRewards(LadderStrings<Reward> rewards) {
        List<Reward> nameList = rewards.getValue();
        System.out.println(nameList.stream()
                .map(Reward::getValue)
                .map(OutputView::padding)
                .collect(Collectors.joining(EMPTY_DELIMITER)));
    }

    public static void printResult(Result result) {
        System.out.println(REWARD_RESULT_MESSAGE);
        System.out.println(result.reward());
    }

    public static void printResults(Results results) {
        System.out.println(REWARD_RESULT_MESSAGE);
//        for (Result result : results.value()) {
//            System.out.printf(PRINT_ALL_FORMAT, result.name(), result.reward());
//        }
        results.value().stream()
                .forEach(result -> System.out.printf(PRINT_ALL_FORMAT, result.name(), result.reward()));
    }

    private static void enter() {
        System.out.println();
    }

}
