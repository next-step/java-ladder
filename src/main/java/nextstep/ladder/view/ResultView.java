package nextstep.ladder.view;

import nextstep.ladder.dto.LadderResult;
import nextstep.ladder.dto.RowDto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static nextstep.ladder.domain.player.Player.MAXIMUM_LENGTH_OF_NAME;

public class ResultView {
    private static final int PADDING = 1;
    private static final String STEP_MARK = "-";
    private static final String BLANK_MARK = " ";
    private static final String COLUMN_MARK = "|";
    private static final String RESULT_STATEMENT = "실행결과";
    private static final String NAME_FORMAT = "%" + (MAXIMUM_LENGTH_OF_NAME + PADDING) + "s";
    private static final String COLUMN_WITH_STEP = COLUMN_MARK + drawStep(STEP_MARK);
    private static final String COLUMN_WITHOUT_STEP = COLUMN_MARK + drawStep(BLANK_MARK);

    private ResultView() {}

    public static void printResult(LadderResult result) {
        Stream.generate(() -> STEP_MARK).limit(MAXIMUM_LENGTH_OF_NAME).collect(Collectors.joining());
        printStatementAndNewLine(RESULT_STATEMENT);

        printPlayers(result.getNames());
        printLadder(result.getRows());
    }

    private static void printLadder(List<RowDto> rowDtos) {
        rowDtos.forEach(ResultView::printSteps);
    }

    private static void printSteps(RowDto rowDto) {
        rowDto.getSteps()
                .forEach(step -> printStatement(step ? COLUMN_WITH_STEP : COLUMN_WITHOUT_STEP));
        newLine();
    }

    private static void printPlayers(List<String> names) {
        names.stream()
                .map(name -> String.format(NAME_FORMAT, name))
                .forEach(ResultView::printStatement);
        newLine();
    }

    private static void newLine() {
        System.out.println();
    }

    private static void printStatement(String statement) {
        System.out.print(statement);
    }

    private static void printStatementAndNewLine(String statement) {
        printStatement(statement);
        newLine();
    }

    private static String drawStep(String mark) {
        return Stream.generate(() -> mark)
                .limit(MAXIMUM_LENGTH_OF_NAME)
                .collect(Collectors.joining());
    }
}
