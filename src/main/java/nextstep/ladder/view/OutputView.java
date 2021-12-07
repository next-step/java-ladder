package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class OutputView {
    private static final String COL = "|";
    private static final String LINE = "-----";
    private static final String EMPTY_LINE = "     ";
    private static final String PLAY_RESULT = "실행 결과";
    private static final String PLAYERS_COUNT_ERROR_MESSAGE = "최소 2명 이상 입력하세요";
    private static final String FORMAT = "%-6s";
    private static final String rnqns = " : ";

    private OutputView() {
    }

    public static void printLadder(Players players, Ladder ladder, Results results) {
        printPlayers(players);

        List<Line> lines = ladder.getLines();
        for (Line line : lines) {
            List<Column> columns = line.getLine();
            printColumns(columns);
            System.out.print(COL);
            System.out.println();
        }

        printResults(results);
    }

    private static void printColumns(List<Column> columns) {
        for (int i = 0; i < columns.size() - 1; i++) {
            printColumn(columns.get(i));
        }
    }

    private static void printColumn(Column column) {
        System.out.print(COL);
        if (column.isRight()) {
            System.out.print(LINE);
            return;
        }
        System.out.print(EMPTY_LINE);
    }

    private static void printPlayers(Players players) {
        List<Player> playerList = players.players();
        for (Player player : playerList) {
            System.out.printf(FORMAT, player.name());
        }
        System.out.println();
    }

    private static void printResults(Results results) {
        List<Result> resultList = results.getResults();

        for (Result result : resultList) {
            System.out.printf(FORMAT, result.name());
        }
        System.out.println();
    }

    public static void printPlayersCountError() {
        System.out.println(PLAYERS_COUNT_ERROR_MESSAGE);
    }

    public static void printResult(Result result) {
        System.out.println(PLAY_RESULT);
        System.out.println(result.name());
    }

    public static void printLadderResult(LadderResult ladderResult) {
        Map<Player, Result> allPlayerResult = ladderResult.resultsOfAllPlayers();
        Set<Player> players = allPlayerResult.keySet();

        System.out.println(PLAY_RESULT);

        for (Player player : players) {
            Result result = ladderResult.resultOfPlayer(player);
            System.out.print(player.name());
            System.out.print(rnqns);
            System.out.print(result.name());
            System.out.println();
        }
    }
}
