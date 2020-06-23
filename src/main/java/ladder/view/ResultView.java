package ladder.view;

import ladder.domain.ladder.Game;
import ladder.domain.play.Item;

import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {
    public static void printResult(Game game) {
        System.out.println("실행 결과");
        printLadder(game);
    }

    private static void printLadder(Game game) {
        System.out.println(game.toString());
    }

    public static void printResults(Map<Item, Item> results) {
        int size = results.size();
        if (size == 1) {
            System.out.println(results.entrySet().stream()
                    .map(itemItemEntry -> itemItemEntry.getValue().getInput())
                    .collect(Collectors.joining()));
            return;
        }

        System.out.println(results.entrySet().stream()
                .map(itemItemEntry -> itemItemEntry.getKey().getInput() + " : " + itemItemEntry.getValue().getInput())
                .collect(Collectors.joining("\n")));
    }
}
