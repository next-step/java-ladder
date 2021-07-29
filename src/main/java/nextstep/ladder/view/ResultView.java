package nextstep.ladder.view;

import nextstep.ladder.dto.LadderResult;
import nextstep.ladder.dto.MatchResult;
import nextstep.ladder.dto.RowDto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static nextstep.ladder.domain.player.Player.MAXIMUM_LENGTH_OF_NAME;

public class ResultView {
    private static final int NAME_PADDING = 1;
    private static final String STEP_MARK = "-";
    private static final String BLANK_MARK = " ";
    private static final String COLUMN_MARK = "|";
    private static final String PADDING = drawStep(BLANK_MARK);
    private static final String LADDER_RESULT_STATEMENT = "사다리 결과";
    private static final String RIDE_RESULT_STATEMENT = "실행 결과";
    private static final String VALUE_FORMAT = "%" + (MAXIMUM_LENGTH_OF_NAME + NAME_PADDING) + "s";
    private static final String COLUMN_WITH_STEP = COLUMN_MARK + drawStep(STEP_MARK);
    private static final String COLUMN_WITHOUT_STEP = COLUMN_MARK + drawStep(BLANK_MARK);
    private static final String PLAYER_AND_RESULT_FORMAT = "%s : %s";
    private static final String PLAYER_NOT_PARTICIPATED_FORMAT = "%s 는 참가하지 않았습니다.";

    private ResultView() {}

    public static void printResult(LadderResult result) {
        printStatementAndNewLine(LADDER_RESULT_STATEMENT);

        printInputValue(result.getNames());
        printLadder(result.getRows());
        printInputValue(result.getResults());
    }

    private static void printLadder(List<RowDto> rowDtos) {
        rowDtos.forEach(ResultView::printSteps);
    }

    private static void printSteps(RowDto rowDto) {
        printStatement(PADDING);
        rowDto.getSteps()
                .forEach(step -> printStatement(step ? COLUMN_WITH_STEP : COLUMN_WITHOUT_STEP));
        newLine();
    }

    private static void printInputValue(List<String> inputValues) {
        inputValues.stream()
                .map(inputValue -> String.format(VALUE_FORMAT, inputValue))
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

    public static void printOneResult(MatchResult matchResult, String playerToSee) {
        printStatementAndNewLine(RIDE_RESULT_STATEMENT);

        if (matchResult.notParticipate(playerToSee)) {
            printStatementAndNewLine(String.format(PLAYER_NOT_PARTICIPATED_FORMAT, playerToSee));
            return;
        }

        printPlayerAndResult(playerToSee, matchResult.getPrize(playerToSee));
    }

    public static void printAllMatchResult(MatchResult matchResult) {
        printStatementAndNewLine(RIDE_RESULT_STATEMENT);

        matchResult.getPlayers()
                .forEach(player -> printPlayerAndResult(player, matchResult.getPrize(player)));
    }

    private static void printPlayerAndResult(String player, String result) {
        printStatementAndNewLine(String.format(PLAYER_AND_RESULT_FORMAT, player, result));
    }
}
