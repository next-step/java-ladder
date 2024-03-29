package laddergame.view;

import laddergame.domain.Player;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String PLAYER_INPUT_GUIDE_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String COMMA_DELIMITER = ",";
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {

    }

    public static List<Player> enteredPlayers() {
        System.out.println(PLAYER_INPUT_GUIDE_MESSAGE);

        String nameOfPlayers = SCANNER.nextLine();

        return Arrays.stream(nameOfPlayers.split(COMMA_DELIMITER))
                .map(Player::valueOf)
                .collect(Collectors.toList());
    }

}
