package ladder.view;

import ladder.domain.*;

import java.util.concurrent.atomic.AtomicInteger;

public class ResultView {
    private final static String LADDER_RESULT = "사다리 결과";
    private final static String PLAYER_RESULT = "실행 결과";
    private final static String LADDER_LEG = "|";
    private final static String LADDER_BOTTOM_TRUE = "-----";
    private final static String LADDER_BOTTOM_FALSE = "     ";

    public static void viewResult(Players players, Ladder ladder, Results results) {
        System.out.println(LADDER_RESULT);
        System.out.println();

        viewPlayerNames(players);
        viewLadder(players, ladder);
        viewResults(players, results);
    }

    public static void viewPlayerResult(PlayerResults playerResults, String playerName) {
        System.out.println(PLAYER_RESULT);
        viewResultOfPlayers(playerResults, playerName);
    }

    private static void viewResultOfPlayers(PlayerResults playerResults, String playerName) {
        if (playerName.equals("all")) {
            viewAllResultOfPlayers(playerResults);
            return;
        }
        System.out.println(playerResults.getResultValueByPlayerName(playerName));
    }

    private static void viewAllResultOfPlayers(PlayerResults playerResults) {
        playerResults.getPlayerResults().stream()
                .forEach(playerResult -> {
                    System.out.println(playerResult.getPlayer().getName() + " : " + playerResult.getResult().getResultValue());
                });
    }

    public static void viewPlayerNames(Players players) {
        for (int i = 0; i < players.getCountOrPerson(); i++) {
            printBlankBeforeName(players, i);
            System.out.print(players.getPlayerName(i));
            System.out.print(" ");
        }
        System.out.println();
    }

    private static void printBlankBeforeName(Players players, int i) {
        if (i != 0) {
            System.out.print(" ".repeat(5 - players.getPlayerName(i).length()));
        }
    }

    public static void viewLadder(Players players, Ladder ladder) {
        ladder.getLines()
                .stream()
                .filter(point -> point != null)
                .forEach(line -> {
                    System.out.print(" ".repeat(players.getPlayerName(0).length() - 1));
                    System.out.print(LADDER_LEG);
                    viewLine(line);
                    System.out.println();
                });
    }

    private static void viewLine(Line line) {
        line.getPoints().forEach(point -> {
            viewPoint(point);
            System.out.print(LADDER_LEG);
        });
    }

    private static void viewPoint(Point point) {
        if (point.isTrue()) {
            System.out.print(LADDER_BOTTOM_TRUE);
            return;
        }
        System.out.print(LADDER_BOTTOM_FALSE);
    }

    public static void viewResults(Players players, Results results) {
        AtomicInteger idx = new AtomicInteger();
        results.getResults()
                .stream()
                .forEach(result -> {
                    printBlankBeforeName(players, idx.get());
                    System.out.print(result.getResultValue());
                    printBlankAfterResult(result, players, idx.getAndIncrement());
                    System.out.print(" ");
                });

        System.out.println();
        System.out.println();
    }

    private static void printBlankAfterResult(Result result, Players players, int idx) {
        if (idx != players.getCountOrPerson()) {
            System.out.print(" ".repeat(players.getPlayerName(idx).length() - result.getResultValue().length()));
        }
    }

}
