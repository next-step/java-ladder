package ladder.view;

import ladder.domain.Player;
import ladder.domain.Players;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Input {
    static Scanner scanner = new Scanner(System.in);

    private Input() {
        throw new AssertionError("Cannot instantiate Input class");
    }

    public static int scanHeight() {
        System.out.println("Put max height of ladders");
        return Integer.parseInt(scanner.nextLine());
    }

    public static Players scanPlayers() {
        System.out.println("Put player names separated by ','.");
        return parsePlayers(scanner.nextLine());
    }

    public static Players parsePlayers(String line) {
        return new Players(Arrays.stream(line.split("\\s*,\\s*"))
                .map(Player::new)
                .collect(Collectors.toList()));
    }

    public static List<String> scanRewards() {
        System.out.println("Put Execution results separated by ','.");
        return parseResults(scanner.nextLine());
    }

    private static List<String> parseResults(String nextLine) {
        return Arrays.stream(nextLine.split("\\s*,\\s*"))
                .collect(Collectors.toList());
    }

    public static Players scanPlayerToShow(Players players) {
        String payload = players.players()
                .stream()
                .map(player -> player.name()) // Q: 단순 print 로직인데 getter 없애는 방법?
                .reduce((acc, cur) -> acc + ", " + cur)
                .orElseThrow(() -> new RuntimeException("unreachable."));
        Output.print("Put person to show reward.\nOptions: " + payload + " (or 'all')\n");
        String playerName = scanner.nextLine();
        if (playerName.equals("all")) {
            return players;
        }
        return players.findPlayers(playerName);
    }

    public static String scanPlayerName(Players players) {
        String payload = players.players()
                .stream()
                .map(player -> player.name()) // Q: 단순 print 로직인데 getter 없애는 방법?
                .reduce((acc, cur) -> acc + ", " + cur)
                .orElseThrow(() -> new RuntimeException("unreachable."));
        Output.print("Put person to show reward.\nOptions: " + payload + " (or 'all')\n");
        return scanner.nextLine();
    }
}
