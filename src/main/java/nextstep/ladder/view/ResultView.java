package nextstep.ladder.view;

import java.util.stream.Collectors;
import nextstep.ladder.domain.HorizontalLine;
import nextstep.ladder.view.dto.PrintHorizontalLinesDto;
import nextstep.ladder.view.dto.PrintPlayerNamesDto;
import nextstep.ladder.view.dto.PrintResultsDto;

public class ResultView {

    private static final String LINE_FLAG = "-----";
    private static final String LINE_BLANK = "     ";
    private static final String LINE_DELIMITER = "|";

    public static void printPlayerNames(final PrintPlayerNamesDto dto) {
        dto.getPlayerNames().forEach(name -> System.out.printf("%6s", name));
        System.out.println();
    }

    public static void printlnResults(final PrintResultsDto dto) {
        dto.getValues().forEach(ResultView::printResult);
        System.out.println();
    }

    private static void printResult(final String result) {
        System.out.printf("%6s", result);
    }

    public static void printLines(final PrintHorizontalLinesDto dto) {
        dto.getLines().stream()
            .map(ResultView::printLine)
            .forEach(System.out::println);
    }

    private static String printLine(final HorizontalLine line) {
        return line.getPoints().stream()
            .map(point -> point.getLeft() ? LINE_FLAG : LINE_BLANK)
            .collect(Collectors.joining(LINE_DELIMITER)) + LINE_DELIMITER;
    }
}
