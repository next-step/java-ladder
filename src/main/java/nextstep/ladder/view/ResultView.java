package nextstep.ladder.view;

import java.util.stream.Collectors;
import nextstep.ladder.view.dto.PrintLineDto;
import nextstep.ladder.view.dto.PrintLinesDto;
import nextstep.ladder.view.dto.PrintPlayerNamesDto;

public class ResultView {

    private static final String LINE_FLAG = "-----";
    private static final String LINE_BLANK = "     ";
    private static final String LINE_DELIMITER = "|";

    public static void printPlayerNames(PrintPlayerNamesDto dto) {
        dto.getPlayerNames().forEach(name -> System.out.printf("%6s", name));
        System.out.println();
    }

    public static void printLadders(PrintLinesDto dto) {
        dto.getLines().stream()
            .map(ResultView::createLineBody)
            .forEach(System.out::println);
    }

    private static String createLineBody(PrintLineDto dto) {
        return dto.getExists().stream()
            .map(e -> e ? LINE_FLAG : LINE_BLANK)
            .collect(Collectors.joining(LINE_DELIMITER)) + LINE_DELIMITER;
    }
}
