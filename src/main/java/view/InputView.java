package view;

import domain.Player;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public List<Player> promptForPlayer() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return Arrays.stream(input.split(","))
                .map(Player::new)
                .collect(Collectors.toList());
    }
}
