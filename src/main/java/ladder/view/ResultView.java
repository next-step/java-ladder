package ladder.view;

import ladder.domain.ExecutionResults;
import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.domain.Point;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultView {
    private final static String MESSAGE_LADDER_RESULT = "사다리 결과";
    private final static String MESSAGE_EXECUTION_RESULT = "실행결과";
    private final static int singleSize = 1;
    private final static int firstIndex = 0;
    private final static Map<Point, String> printPoints = new HashMap<>();

    static {
        printPoints.put(Point.LEFT, "--|");
        printPoints.put(Point.DOWN, "     |");
        printPoints.put(Point.RIGHT, "     |---");
    }

    private ResultView() {
    }

    public static void printPlayers(List<String> players){
        System.out.println();
        System.out.println(MESSAGE_LADDER_RESULT);
        System.out.println();
        players.stream()
                .map(player -> String.format("%6s", player))
                .forEach(System.out::print);
        System.out.println();
    }

    public static void printLadder(Ladder ladder){
        ladder.lines()
                .stream()
                .forEach(line -> {
                    line.points()
                            .forEach(point -> System.out.print(printPoints.get(point)));
                    System.out.println();
                });
    }

    public static void printResult(ExecutionResults executionResults) {
        executionResults.executionResults()
                .stream()
                .map(result -> String.format("%6s", result))
                .forEach(System.out::print);
        System.out.println();
    }

    public static void printExecutionResult(HashMap<String, String> result){
        System.out.println();
        System.out.println(MESSAGE_EXECUTION_RESULT);
        if(result.size() == singleSize){
            System.out.println(result.values().toArray()[firstIndex]);
            return;
        }
        for(String player : result.keySet()) {
            System.out.println(String.format("%s : %s", player, result.get(player)));
        }
    }
}
