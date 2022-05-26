package ladder.view;

import ladder.controller.Reward;
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
    public static int scanNumber() {
        System.out.println("Put max height of ladders");
        return scanner.nextInt();
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

     public static List<Reward> scanRewards() {
         System.out.println("Put Execution results separated by ','.");
         return parseResults(scanner.nextLine());
     }

     private static List<Reward> parseResults(String nextLine) {
         Arrays.stream(nextLine.split("\\s*,\\s*")).map(Reward::new).collect(Collectors.toList());
     }
 }
