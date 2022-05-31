package ladder.view;

import ladder.domain.Ladder;
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
        players.forEach(player -> Output.print(format(player.name())));
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

    public static void printLadderResults(List<LadderResult> ladderResults) {
        Output.print("Ladder Result\n");
        ladderResults.forEach(ladderResult -> Output.print(ladderResult.playerName() + ": " + ladderResult.reward() + "\n"));
    }

    public static void printLadder(Ladder ladder) {
        print(ladder.toShow());
    }
}
