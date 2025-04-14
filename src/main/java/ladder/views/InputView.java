package ladder.views;

import ladder.Height;
import ladder.domain.Players;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final static Scanner scanner = new Scanner(System.in);

    public static Players createPlayersWithQuery(String query) {
        System.out.println(query);
        String input = scanner.nextLine();
        String[] names = input.split(",");
        List<String> playerStrings = Arrays.asList(names);

        return Players.createWithNames(playerStrings);
    }

    public static Height createIntegerWithQuery(String query) {
        System.out.println();
        System.out.println(query);
        int parsedInt = Integer.parseInt(scanner.nextLine());
        return new Height(parsedInt);
    }

    public static List<String> createResultsWithQuery(String query) {
        System.out.println();
        System.out.println(query);

        String[] split = scanner.nextLine().split(",");
        return List.of(split);
    }

    public static String createStringWithQuery(String query) {
        System.out.println();
        System.out.println(query);

        return scanner.nextLine();
    }
}
