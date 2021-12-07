package ladder.ui;

import ladder.domain.*;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String RESULT_MESSAGE = "실행 결과\n";
    private static final int NAME_PADDING = 6;
    private static final String TWO_SPACE = "  ";
    private static final String LINE_JOINING_DELIMITER = "\n" + TWO_SPACE;
    private static final String EMPTY_DELIMITER = "";

    public static void printResult(LadderGame ladderGame) {
        System.out.println(RESULT_MESSAGE);
        printNames(ladderGame.getNames());
        printLadders(ladderGame.getLadder());
    }

    private static void printNames(Names names) {
        List<Name> nameList = names.getNames();
        System.out.println(nameList.stream()
                .map(Name::getValue)
                .map(OutputView::padding)
                .collect(Collectors.joining(EMPTY_DELIMITER))
        );
    }

    private static String padding(String name) {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        while (sb.length() < NAME_PADDING) {
            append(sb);
        }
        return sb.toString();
    }

    private static void append(StringBuilder sb) {
        if (sb.length() % 2 == 0) {
            sb.append(' ');
            return;
        }

        sb.insert(0, ' ');
    }

    private static void printLadders(Ladder ladder) {
        StringBuilder sb = new StringBuilder();
        List<Line> lines = ladder.getLines();
        sb.append(TWO_SPACE);
        sb.append(lines.stream()
                .map(OutputView::appendLine)
                .collect(Collectors.joining(LINE_JOINING_DELIMITER)));
        System.out.println(sb.toString());
    }

    private static String appendLine(Line line) {
        List<LadderPart> ladderParts = line.getLadderParts();
        return ladderParts.stream()
                .map(LadderPart::value)
                .collect(Collectors.joining(EMPTY_DELIMITER));
    }

}
