package nextstep.ladder.view;

import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.view.dto.PrintLineDto;
import nextstep.ladder.view.dto.PrintLinesDto;
import nextstep.ladder.view.dto.PrintNameWithResultDto;
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

    public static void printlnResults(final PrintResultsDto dto) {
        dto.getValues().forEach(ResultView::printResult);
        System.out.println();
    }

    private static void printResult(final String result) {
        System.out.printf("%6s", result);
    }

    public static void printNameWithResult(final PrintNameWithResultDto dto) {
        System.out.println("실행 결과");
        System.out.println(dto.getName().getName() + " : " + dto.getResult().getValue());
    }

    public static void printNameWithResults(final List<PrintNameWithResultDto> dtos) {
        System.out.println("실행 결과");
        dtos.forEach(dto -> System.out.println(dto.getName().getName() + " : " + dto.getResult().getValue()));
    }
}
