package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Players;

public class ResultView {

    private final static String MESSAGE_RESULT = "실행결과";
    
    private ResultView(){}

    public static void printResult(Players players, Ladder ladder) {
        System.out.println();
        System.out.println(MESSAGE_RESULT);
        System.out.println();
        printPlayers(players);
        System.out.println(ladder);
    }

    private static void printPlayers(Players players){
        players.players()
                .stream()
                .map(player -> String.format("%6s", player.name()))
                .forEach(System.out::print);
        System.out.println();
    }

}
