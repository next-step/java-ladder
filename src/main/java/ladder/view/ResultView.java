package ladder.view;

import ladder.model.ladder.Ladder;
import ladder.model.ladder.Line;
import ladder.model.point.Point;
import ladder.model.player.Player;
import ladder.model.player.Players;
import ladder.model.result.Result;
import ladder.model.result.Results;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ResultView {

    public static void printLadderResult(Players players, Ladder ladder, Results results) {
        System.out.println("사다리 결과");
        System.out.println();
        printPlayerName(players.get());
        printLadder(ladder);
        printResults(results.get());
    }

    private static void printPlayerName(List<Player> players) {
        players.forEach(player -> System.out.printf("%5s ", player.name()));
        System.out.println();
    }

    private static void printLadder(Ladder ladder) {
        ladder.lines().forEach(ResultView::printLine);
    }

    private static void printLine(Line line) {
        line.points()
                .get()
                .forEach(ResultView::printPoint);
        System.out.println();
    }

    private static void printPoint(Point point) {
        String value = " ";
        if(point.isLeft())  {
            value = "-";
        }
        System.out.print(String.join("", Collections.nCopies(5, value)) + "|");
    }

    private static void printResults(List<Result> results) {
        results.forEach(result -> System.out.printf("%-5s ", result.get()));
        System.out.println();
    }

    public static void printResult(Map<String, String> resultMap, String name) {
        System.out.println("실행 결과");
        if(name.equals("all")) {
            printAll(resultMap);
        }
        if(resultMap.containsKey(name)) {
            System.out.println(resultMap.get(name));
        }
    }

    private static void printAll(Map<String, String> gameResult) {
        gameResult.forEach((name,result) -> System.out.println(name + " : " + result));
    }
}
