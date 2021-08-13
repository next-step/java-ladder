package nextstep.ladder.view;

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
}
