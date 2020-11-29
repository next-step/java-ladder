package nextstep.ladder.view;

import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.Players;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OutputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final PrintStream out = System.out;
    public static final String BLANK = " ";

    public static void showPlayers(Players players) {
        out.println(players.getPlayers().stream()
                .map(Player::getName)
                .map(name -> String.format("%5s", name))
                .collect(Collectors.joining(BLANK)));
    }
}
