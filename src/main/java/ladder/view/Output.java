package ladder.view;

import ladder.domain.LadderResult;
import ladder.domain.Row;
import ladder.domain.Player;

import java.util.List;

public class Output {
    public static void print(String payload) {
        System.out.print(payload);
    }

    public static void printPlayers(List<Player> players) {
        Output.print(" ".repeat(2));
        players.forEach(p -> Output.print(format(p.name())));
        Output.print("\n");
    }

    public static void printLines(List<Row> lines) {
        lines.forEach(line -> {
            System.out.print(" ".repeat(4));
//            Output.printLine(line.points());
            System.out.println();
        });

    }

    public static void printLine(List<Boolean> points) {
        points
                .stream()
                .map(p -> p ? "-" : " ")
                .map(p -> "|" + p.repeat(5))
                .forEach(System.out::print);
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

    public static void printLadderResults(List<LadderResult> ladderResults) {
        Output.print("Ladder Result\n");
        ladderResults.forEach(ladderResult -> Output.print(ladderResult.playerName() + ": " + ladderResult.reward() + "\n"));
    }
}
