package nextstep.ladder.domain.view;

import nextstep.ladder.domain.dto.ResultDto;
import nextstep.ladder.domain.dto.RowDto;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static nextstep.ladder.domain.player.Player.NAME_LENGTH_LIMIT;

public class ResultView {
    private static final int NAME_PADDING_SIZE = 1;
    private static final int NAME_FORMAT_SIZE = NAME_LENGTH_LIMIT + NAME_PADDING_SIZE;

    private static final String RESULT_MESSAGE = "실행결과";
    private static final String SPACE_MARK = " ";
    private static final String LINE_MARK = "-";
    private static final String COLUMN_MARK = "|";
    private static final String NAME_FORMAT = MessageFormat.format("%{0}s", NAME_FORMAT_SIZE);

    private ResultView() {}

    public static void printResult(final ResultDto result) {
        println(RESULT_MESSAGE);

        printPlayerNames(result.getNames());

        printLadder(result.getRows());
    }

    private static void printPlayerNames(final List<String> names) {
        names.stream()
             .map(name -> String.format(NAME_FORMAT, name))
             .forEach(ResultView::print);

        newLine();
    }

    private static void printLadder(final List<RowDto> rowDtos) {
        rowDtos.forEach(ResultView::printDirections);
    }

    private static void printDirections(final RowDto rowDto) {
        print(concatToTheLimitLength(SPACE_MARK));

        rowDto.getDirections()
              .forEach(direction -> print(direction ?
                                          MessageFormat.format("{0}{1}", COLUMN_MARK, concatToTheLimitLength(LINE_MARK)) :
                                          MessageFormat.format("{0}{1}", COLUMN_MARK, concatToTheLimitLength(SPACE_MARK))
              ));

        newLine();
    }

    private static String concatToTheLimitLength(final String charSequence) {
        return Stream.generate(() -> charSequence)
                     .limit(NAME_LENGTH_LIMIT)
                     .collect(Collectors.joining());
    }

    public static void print(final String message) {
        System.out.print(message);
    }

    public static void println(final String message) {
        System.out.println(message);
    }

    public static void newLine() {
        System.out.println();
    }
}
