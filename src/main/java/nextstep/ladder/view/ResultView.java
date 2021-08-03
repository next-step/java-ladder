package nextstep.ladder.view;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.view.dto.PrintPlayerNamesDto;

public class ResultView {

    private static final String LINE_FLAG = "-----";
    private static final String LINE_BLANK = "     ";
    private static final String LINE_DELIMITER = "|";

    private static final String LINE_PREFIX = LINE_BLANK + LINE_DELIMITER;

    public static void printPlayerNames(PrintPlayerNamesDto dto) {
        dto.getPlayerNames().forEach(name -> System.out.printf("%6s", name));
        System.out.println();
    }

    public static void printLadders(Lines lines) {
        List<String> printString = new ArrayList<>();

        for (int i = 0; i < lines.getHeight(); i++) {
            printString.add(LINE_PREFIX + createLineBody(lines, i) + LINE_DELIMITER);
        }

        printString.forEach(System.out::println);
    }

    private static String createLineBody(Lines lines, int i) {
        return lines.getExists(i).stream()
            .map(e -> {
                if (e) {
                    return LINE_FLAG;
                }

                return LINE_BLANK;
            }).collect(Collectors.joining(LINE_DELIMITER));
    }
}
