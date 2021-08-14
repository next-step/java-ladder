package nextstep.ladder.view;

import java.util.stream.Collectors;
import nextstep.ladder.view.dto.PrintHorizontalLineDto;
import nextstep.ladder.view.dto.PrintHorizontalLinesDto;
import nextstep.ladder.view.dto.PrintPlayerDto;
import nextstep.ladder.view.dto.PrintPlayersDto;
import nextstep.ladder.view.dto.PrintResultsDto;

public class ResultView {

    private static final String LINE_FLAG = "-----";
    private static final String LINE_BLANK = "     ";
    private static final String LINE_DELIMITER = "|";

    public static void printPlayerNames(final PrintPlayersDto dto) {
        dto.getPlayers().forEach(player -> System.out.printf("%6s", player.getName()));
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

    private static String printLine(final PrintHorizontalLineDto dto) {
        return dto.getPoints().stream()
            .map(point -> point.getLeft() ? LINE_FLAG : LINE_BLANK)
            .collect(Collectors.joining(LINE_DELIMITER)) + LINE_DELIMITER;
    }

    public static void printNameWithResult(final PrintPlayerDto dto) {
        System.out.println("실행 결과");
        System.out.println(dto.getName() + " : " + dto.getResult());
    }

    public static void printNameWithResults(final PrintPlayersDto dto) {
        System.out.println("실행 결과");
        dto.getPlayers()
            .forEach(player -> System.out.println(player.getName() + " : " + player.getResult()));
    }
}
