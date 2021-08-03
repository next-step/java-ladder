package nextstep.ladder.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
        IntStream.range(0, lines.getHeight())
            .mapToObj(i -> createLineBody(lines.getExists(i)))
            .map(s -> LINE_PREFIX + s)
            .forEach(System.out::println);
    }

    private static String createLineBody(List<Boolean> lineExists) {
        return lineExists.stream()
            .map(e -> {
                if (e) {
                    return LINE_FLAG;
                }

                return LINE_BLANK;
            }).collect(Collectors.joining(LINE_DELIMITER)) + LINE_DELIMITER;
    }
}
