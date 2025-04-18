package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.Map;

public class ResultView {
    private static final String VERTICAL = "|";
    private static final String HORIZONTAL = "-----";
    private static final String EMPTY = "     ";

    public static void printLadderResultMessage(){
        System.out.println("사다리 결과\n");
    }

    public static void printPlayers(Players players) {
        players.getPlayers().forEach(player ->
                System.out.printf("%-6s", player.getName()));
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            for (Point point : line.getPoints()) {
                System.out.print(VERTICAL);
                if (point.hasRight()) {
                    System.out.print(HORIZONTAL);
                } else {
                    System.out.print(EMPTY);
                }
            }
            System.out.println();
        }
    }

    public static void printResults(Results results){
        results.getResults().forEach(result ->
                System.out.printf("%-6s", result.getResult()));
        System.out.println();
        System.out.println();
    }

    public static void printSingleResult(String result) {
        System.out.println("실행 결과");
        System.out.println(result);
        System.out.println();
    }

    public static void printAllResults(Map<String, Result> resultsByName) {
        System.out.println("실행 결과");
        resultsByName.forEach((name, result) ->
                System.out.println(name + " : " + result.getResult()));
        System.out.println();
    }
}
