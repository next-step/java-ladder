package ladder.ui;

import ladder.domain.*;
import ladder.dto.LadderGame;
import ladder.util.function.Function;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String RESULT_MESSAGE = "실행 결과\n";
    private static final int NAME_PADDING = 6;
    private static final char SPACE = ' ';
    private static final String TWO_SPACE = "  ";
    private static final String LINE_JOINING_DELIMITER = "\n" + TWO_SPACE;
    private static final String EMPTY_DELIMITER = "";
    private static final StringBuilder STRING_BUILDER = new StringBuilder();
    private static final int STRING_BUILDER_DEFAULT_LENGTH = 0;

    private OutputView() {}

    public static void printResult(LadderGame ladderGame) {
        System.out.println(RESULT_MESSAGE);
        printNames(ladderGame.getNames());
        printLadders(ladderGame.getLadder());
    }

    private static void printNames(Names names) {
        List<Name> nameList = names.getValue();
        System.out.println(nameList.stream()
                .map(Name::getValue)
                .map(OutputView::padding)
                .collect(Collectors.joining(EMPTY_DELIMITER))
        );
    }

    private static String padding(String name) {
        STRING_BUILDER.setLength(STRING_BUILDER_DEFAULT_LENGTH);
        STRING_BUILDER.append(name);
        while (STRING_BUILDER.length() < NAME_PADDING) {
            append(STRING_BUILDER);
        }
        return STRING_BUILDER.toString();
    }

    private static void append(StringBuilder sb) {
        if (Function.EVEN_NUMBER.test(sb.length())) {
            sb.append(SPACE);
            return;
        }

        sb.insert(STRING_BUILDER_DEFAULT_LENGTH, SPACE);
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
                .map(LadderPart::value)
                .collect(Collectors.joining(EMPTY_DELIMITER));
    }

}
