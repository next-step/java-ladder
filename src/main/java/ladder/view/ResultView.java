package ladder.view;

import ladder.domain.*;

public class ResultView {

    public static void drawLadderPlayers(LadderPlayers players) {
        System.out.println();
        System.out.println("사다리결과");
        System.out.println();

        players.getPlayers()
                .forEach(System.out::print);

        System.out.println();

    }

    public static void drawLadder(Ladder ladder) {
        ladder.getLines()
                .forEach(System.out::println);
    }

    public static void drawResults(LadderResult result) {
       result.getResults()
               .forEach(System.out::print);

       System.out.println();

    }

    public static void showResults(String playerName, GameResult result) {
        System.out.println();
        System.out.println("실행결과");
        System.out.println(result.findPlayerResult(playerName));
    }

    public static void printAllResults(GameResult result) {
        System.out.println();
        System.out.println("실행결과");
        System.out.println(result);
    }
}
