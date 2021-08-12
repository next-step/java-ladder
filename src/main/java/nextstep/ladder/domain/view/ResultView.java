package nextstep.ladder.domain.view;

import nextstep.ladder.domain.dto.ResultDto;
import nextstep.ladder.domain.dto.RowDto;
import nextstep.ladder.domain.exception.PlayerNotFoundException;
import nextstep.ladder.domain.player.Players;

import java.text.MessageFormat;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static nextstep.ladder.domain.player.Player.NAME_LENGTH_LIMIT;

public class ResultView {
    private static final int NAME_PADDING_SIZE = 1;
    private static final int NAME_FORMAT_SIZE = NAME_LENGTH_LIMIT + NAME_PADDING_SIZE;

    private static final String RESULT_MESSAGE = "실행결과";
    private static final String DO_WHILE_END_TRIGGER = "all";

    private static final String SPACE_MARK = " ";
    private static final String LINE_MARK = "-";
    private static final String COLUMN_MARK = "|";
    private static final String NAME_FORMAT = MessageFormat.format("%{0}s", NAME_FORMAT_SIZE);
    private static final String RESULT_FORMAT = "%s : %s%n";

    private ResultView() {}

    public static void printResultStatement(final ResultDto result) {
        println(RESULT_MESSAGE);
        printPlayerNames(result.getNames());
        printLadder(result.getRows());
        printEndpoints(result.getEndpoints());
    }

    private static void printPlayerNames(final Set<String> names) {
        names.stream()
             .map(name -> String.format(NAME_FORMAT, name))
             .forEach(ResultView::printResult);

        newLine();
    }

    private static void printLadder(final List<RowDto> rowDtos) {
        rowDtos.forEach(ResultView::printDirections);
    }

    private static void printDirections(final RowDto rowDto) {
        printResult(concatToTheLimitLength(SPACE_MARK));

        rowDto.getDirections()
              .forEach(direction -> printResult(
                      direction ?
                      MessageFormat.format("{0}{1}", COLUMN_MARK, concatToTheLimitLength(LINE_MARK)) :
                      MessageFormat.format("{0}{1}", COLUMN_MARK, concatToTheLimitLength(SPACE_MARK))
              ));

        newLine();
    }

    private static void printEndpoints(final List<String> endpoints) {
        endpoints.stream()
                 .map(endpoint -> String.format(NAME_FORMAT, endpoint))
                 .forEach(ResultView::printResult);

        newLine();
        newLine();
    }

    public static void printResultAll(final Players players, final ResultDto resultDto) {
        newLine();
        ResultView.printResultStatement(resultDto);
        ResultView.printLoop(resultDto, players);
        ResultView.printEndMessage(resultDto);
    }

    public static void printLoop(final ResultDto resultDto, final Players players) {
        Set<String> names = resultDto.getNames();
        while (true) {
            String name = InputView.whoWantsToSeeTheResults();

            if (DO_WHILE_END_TRIGGER.equals(name)) {
                break;
            }

            if (!names.contains(name)) {
                throw new PlayerNotFoundException("참가자를 찾을 수 없습니다.");
            }

            ResultView.println(resultDto.getEndpoint(resultDto.getPosition(name)));
            ResultView.newLine();
        }
    }

    public static void printEndMessage(final ResultDto resultDto) {
        println(RESULT_MESSAGE);
        resultDto.getNames().forEach(printResult(resultDto));
    }

    private static Consumer<String> printResult(final ResultDto resultDto) {
        return name -> printResult(resultDto, name);
    }

    private static void printResult(final ResultDto resultDto, final String name) {
        final int position = resultDto.getPosition(name);
        final String endpoint = resultDto.getEndpoint(position);
        printf(RESULT_FORMAT, name, endpoint);
    }

    private static String concatToTheLimitLength(final String charSequence) {
        return Stream.generate(() -> charSequence)
                     .limit(NAME_LENGTH_LIMIT)
                     .collect(Collectors.joining());
    }

    public static void printResult(final String message) {
        System.out.print(message);
    }

    public static void println(final String message) {
        System.out.println(message);
    }

    public static void printf(final String format, final Object... args) {
        System.out.printf(format, args);
    }

    public static void newLine() {
        System.out.println();
    }
}
