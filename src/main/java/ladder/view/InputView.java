package ladder.view;

import ladder.model.Player;

import java.util.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private final static Scanner scanner = new Scanner(System.in);
    private InputView() {}

    public static List<Player> getPlayers() {
        String playerNames = getStringValue("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요");
        return Arrays.stream(playerNames.split(","))
                .map(Player::new)
                .collect(Collectors.toList());
    }

    private static String getStringValue(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
}
