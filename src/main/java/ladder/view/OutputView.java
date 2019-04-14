package ladder.view;


import ladder.domain.*;

import java.util.List;

public class OutputView {
    public static final String LADDER_RESULT_MENT = "사다리결과";
    public static final String GAME_RESULT_MENT = "실행결과";
    public static final String ALL = "all";

    public static void printLadder(Players players, LadderGame ladderGame, BetItems betItems) {
        System.out.println(LADDER_RESULT_MENT);
        printPlayers(players);
        printLadder(ladderGame.getLadder());
        printBetItems(betItems);
    }

    private static void printBetItems(BetItems betItems) {
        System.out.println(betItems);
    }

    private static void printLadder(Ladder ladder) {
        System.out.println(ladder);
    }

    private static void printPlayers(Players players) {
        System.out.println(players);
    }

    public static void printResult(GameResults gameResults, String selectedPlayer) {
        System.out.println(GAME_RESULT_MENT);
        List<Player> players = gameResults.match(selectedPlayer);
        players.forEach(
                player -> System.out.println(player + " : " + gameResults.find(player))
        );
    }

    public static void endResult(GameResults gameResults) {
        System.out.println(gameResults);
    }

    public static boolean isEndAnswer(String selectionResult) {
        return selectionResult.equals(ALL);
    }
}
