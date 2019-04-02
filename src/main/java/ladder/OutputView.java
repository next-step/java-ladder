package ladder;


public class OutputView {
    public static final String GAME_RESULT_MENT = "실행결과";

    public static void print(Players players, LadderGame ladderGame) {
        System.out.println(GAME_RESULT_MENT);
        printPlayers(players);
        printLadder(ladderGame.getLadder());
    }

    private static void printLadder(Ladder ladder) {
        System.out.println(ladder);
    }

    private static void printPlayers(Players players) {
        System.out.println(players);
    }

}
