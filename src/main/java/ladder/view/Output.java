package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Player;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Output {
    public static void print(String payload) {
        System.out.print(payload);
    }

    public static void printPlayers(List<Player> players) {
        Output.print(" ".repeat(2));
        players.forEach(player -> Output.print(format(player.name()))); // Q: 단순 print 로직인데 getter 없애는 방법?;
        Output.print("\n");
    }

    private static String format(String name) {
        return String.format("%-5s", name)
                .replace(" ", ".") + " ";
    }

    public static void printRewards(List<String> rewards) {
        Output.print(" ".repeat(2));
        rewards.stream()
                .forEach(reward -> Output.print(format(reward)));
        Output.print("\n");
    }

    public static void printLadder(Ladder ladder) {
        print(ladder.toShow());
    }

    public static void printResult(String key, String value) {
        print(key + ": " + value + "\n");
    }

    public static void printResults(Set<Map.Entry<String, String>> resultMap) {
        resultMap.stream()
                .forEach(result -> Output.printResult(result.getKey(), result.getValue()));
    }
}
