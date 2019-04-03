package ladder;


public class OutputView {
    public static final String LADDER_RESULT_MENT = "사다리결과";
    public static final String GAME_RESULT_MENT = "실행결과";
    public static final String ALL = "all";

    public static void printLadder(Players players, LadderGame ladderGame, EndPoints endPoints) {
        System.out.println(LADDER_RESULT_MENT);
        printPlayers(players);
        printLadder(ladderGame.getLadder());
        printEndPoints(endPoints);
    }

    private static void printEndPoints(EndPoints endPoints) {
        System.out.println(endPoints);
    }

    private static void printLadder(Ladder ladder) {
        System.out.println(ladder);
    }

    private static void printPlayers(Players players) {
        System.out.println(players);
    }

    public static void printResult(GameResults gameResults, String selectedPlayer) {
        System.out.println(GAME_RESULT_MENT);
        if (isEndAnswer(selectedPlayer)) {
            System.out.println(gameResults);
            return;
        }
        Player player = gameResults.getPlayers().match(selectedPlayer);
        System.out.println(player.getName() + " : " + gameResults.getResult().get(player).getName());
    }

    public static boolean isEndAnswer(String selectionResult) {
        return selectionResult.equals(ALL);
    }
}
