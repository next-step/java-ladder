package nextstep.ladder.view;

import nextstep.ladder.domain.dto.LadderFigure;
import nextstep.ladder.domain.dto.LadderPlayerGameResult;
import nextstep.ladder.domain.dto.LadderResult;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static nextstep.ladder.domain.player.Player.MAXIMUM_LENGTH_OF_NAME;

public class ResultView {
    private static final String ALL = "ALL";
    private static final String LADDER_RESULT = "사다리 결과";
    private static final String RIDE_RESULT = "실행결과";
    private static final String NAME_FORMAT = "%" + (MAXIMUM_LENGTH_OF_NAME + 1) + "s";
    private static final String LINE_STRING = "-";
    private static final String BLANK_STRING = " ";
    private static final String PILLAR_STRING = "|";
    private static final String PADDING = makeMaxLengthStringWith(BLANK_STRING);
    private static final String PILLAR_WITH_LINE = PILLAR_STRING + makeMaxLengthStringWith(LINE_STRING);
    private static final String PILLAR_WITH_BLANK = PILLAR_STRING + makeMaxLengthStringWith(BLANK_STRING);
    private static final String PLAYER_RESULT_FORMAT = "%s : %s";
    private static final String PLAYER_NOT_PARTICIPATED = "참가하지 않았습니다.";

    private ResultView() {
    }

    public static void printLadderResult(LadderResult result) {
        print(LADDER_RESULT);
        printNextLine();
        printStringValues(result.getPlayerNames());
        printLadder(result.getLadderFigures());
        printStringValues(result.getGameResults());
    }

    public static void printPlayerGameResult(String player, LadderPlayerGameResult gameResult) {
        print(RIDE_RESULT);
        printNextLine();
        printGameResult(player, gameResult);
    }

    private static void printGameResult(String player, LadderPlayerGameResult gameResult) {
        if (isAllPlayer(player)) {
            printAllPlayerGameResult(gameResult);
        } else {
            printOnePlayerGameResult(player, getRecord(player, gameResult));
        }
    }

    private static boolean isAllPlayer(String player) {
        return player.equalsIgnoreCase(ALL);
    }

    private static void printStringValues(List<String> playerNames) {
        printPlayer(playerNames);
        printNextLine();
    }

    private static void printPlayer(List<String> playerNames) {
        playerNames.stream()
                .map(name -> String.format(NAME_FORMAT, name))
                .forEach(ResultView::print);
    }

    private static void printLadder(List<LadderFigure> ladderFigures) {
        ladderFigures.forEach(ResultView::printLines);
    }

    private static void printLines(LadderFigure ladderFigure) {
        print(PADDING);
        printLine(ladderFigure);
        printNextLine();
    }

    private static void printLine(LadderFigure ladderFigure) {
        ladderFigure.getLines()
                .forEach(line -> print(line ? PILLAR_WITH_LINE : PILLAR_WITH_BLANK));
    }

    private static void print(String statement) {
        System.out.print(statement);
    }

    private static void printNextLine() {
        print(System.lineSeparator());
    }

    private static String makeMaxLengthStringWith(String value) {
        return Stream.generate(() -> value)
                .limit(MAXIMUM_LENGTH_OF_NAME)
                .collect(Collectors.joining());
    }

    private static void printAllPlayerGameResult(LadderPlayerGameResult gameResult) {
        gameResult.getPlayers()
                .forEach(player -> printOnePlayerGameResult(player, getRecord(player, gameResult)));
    }

    private static void printOnePlayerGameResult(String player, String result) {
        print(String.format(PLAYER_RESULT_FORMAT, player, result));
        printNextLine();
    }

    private static String getRecord(String player, LadderPlayerGameResult gameResult) {
        String record = gameResult.getRecords(player);
        if (record.isEmpty()) {
            return PLAYER_NOT_PARTICIPATED;
        }

        return record;
    }
}
