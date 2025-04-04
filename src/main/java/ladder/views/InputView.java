package ladder.views;

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
        return new Players(playerStrings);
    }

    public static int createIntegerWithQuery(String query) {
        System.out.println(System.lineSeparator());
        System.out.println(query);
        return Integer.parseInt(scanner.nextLine());
    }
}
