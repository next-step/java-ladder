package view;

import domain.Player;
import domain.Players;
import util.StringUtil;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static final String PLAYER_NAME_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";

    public Players inputPlayers() {
        return inputPlayers(PLAYER_NAME_INPUT_MESSAGE);
    }

    public Players inputPlayers(String message) {
        System.out.println(message);
        List<String> nameList = StringUtil.splitStringToList(SCANNER.nextLine(), ",");
        try {
            List<Player> playerList = nameList.stream()
                    .map(Player::from)
                    .collect(Collectors.toList());

            return Players.from(playerList);
        } catch (IllegalArgumentException e) {
            return inputPlayers(e.getMessage());
        }
    }

}
