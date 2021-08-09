package nextstep.ladder.view;

import java.util.stream.Collectors;
import nextstep.ladder.view.dto.PrintLineDto;
import nextstep.ladder.view.dto.PrintLinesDto;
import nextstep.ladder.view.dto.PrintPlayerNamesDto;
import nextstep.ladder.view.dto.PrintResultDto;

public class ResultView {

    private static final String LINE_FLAG = "-----";
    private static final String LINE_BLANK = "     ";
    private static final String LINE_DELIMITER = "|";

    public static void printPlayerNames(final PrintPlayerNamesDto dto) {
        dto.getPlayerNames().forEach(name -> System.out.printf("%6s", name));
        System.out.println();
    }

    public static void printLadders(final PrintLinesDto dto) {
        dto.getLines().stream()
            .map(ResultView::createLineBody)
            .forEach(System.out::println);
    }

    private static String createLineBody(final PrintLineDto dto) {
        return dto.getExists().stream()
            .map(e -> e ? LINE_FLAG : LINE_BLANK)
            .collect(Collectors.joining(LINE_DELIMITER));
    }

    public static void printResults(final PrintResultDto dto) {
        dto.getValues().forEach(v -> System.out.printf("%6s", v));
        System.out.println();
    }
}
