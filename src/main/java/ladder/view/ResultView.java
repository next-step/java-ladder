package ladder.view;

import ladder.domain.Players;

import java.util.stream.Collectors;

public class ResultView {
    private static final String LADDER_RESULT = "실행결과";
    private static final String PRINT_FORMAT = "%6s";

    public static void printPlayers(Players players) {
        System.out.println(LADDER_RESULT);

        String nameOutput = players.getPlayers().stream()
                .map(player -> String.format(PRINT_FORMAT, player.getName()))
                .collect(Collectors.joining());
        System.out.println(nameOutput);
    }
}
