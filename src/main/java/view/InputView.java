package view;

import domain.Height;
import domain.Player;
import domain.Players;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static Players promptForPlayer() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return new Players(Arrays.stream(input.split(","))
                .map(Player::new)
                .collect(Collectors.toList()));
    }

    public static Height promptForHeight() {
        Scanner scanner = new Scanner(System.in);
        return new Height(scanner.nextInt());
    }
}
